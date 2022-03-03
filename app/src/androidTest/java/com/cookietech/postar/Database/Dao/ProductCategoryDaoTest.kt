package com.cookietech.postar.Database.Dao

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.cookietech.postar.Database.Databases.AppDatabase
import com.cookietech.postar.Database.Entity.ProductCategoryEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters


@RunWith(AndroidJUnit4::class) // we are doing instrument test as we want to create database in android platform
@SmallTest // this is defining that it is a unit test
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ProductCategoryDaoTest {

    private lateinit var database:AppDatabase
    private lateinit var dao:ProductCategoryDao

    private val productCategory1 = ProductCategoryEntity("test_category_1")
    private val productCategory2 = ProductCategoryEntity("test_category_2")
    private val productCategory3 = ProductCategoryEntity("test_category_3")

    private val categories = listOf(productCategory1,productCategory2,productCategory3)

    private lateinit var retrievedCategories:List<ProductCategoryEntity>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule() // telling JUnit to test one by one . Not asynchronously

    @Before // before every test case in this class
    fun createDb() = runBlocking{
        //create a demo database in RAM. Not real database . So do not persist
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java
        ).build()
        dao = database.productCategoryDao

        aInsertProductCategory()
    }

    @After
    fun closeDb(){
        database.close()
    }


    private fun aInsertProductCategory() = runBlocking {
        for(category in categories){
            Log.d("my_test", "aInsertProductCategory: " + category.category_name + " " + category.id)
            dao.insert(category)
        }
    }

    @Test
    fun bGetAllCategory() = runBlocking{
        val retrievedCategories = dao.getAllCategory().first()
        Log.d("my_test", "bGetAllCategory: " + retrievedCategories)

        Assert.assertThat(retrievedCategories.size, Matchers.equalTo(3))

        // Ensure plant list is sorted by name
        Assert.assertThat(retrievedCategories[0], Matchers.equalTo(productCategory1))
        Assert.assertThat(retrievedCategories[1], Matchers.equalTo(productCategory2))
        Assert.assertThat(retrievedCategories[2], Matchers.equalTo(productCategory3))
    }

    @Test
    fun cGetCategoryById() = runBlocking {
        val category = dao.getCategoryById(1).first()

        Assert.assertThat(category, Matchers.equalTo(productCategory1))

    }

    @Test
    fun dUpdateCategory() = runBlocking {
        val category = ProductCategoryEntity("changed_name")
        category.id = 1
        dao.update(category)

        val afterUpdate = dao.getAllCategory().first()

        Assert.assertThat(afterUpdate.size, Matchers.equalTo(3))

        // Ensure plant list is sorted by name
        Assert.assertThat(afterUpdate.filter {  it.id == 1}[0].category_name, Matchers.equalTo("changed_name"))

    }

    @Test
    fun eDeleteCategory() = runBlocking {
        productCategory1.id = 1
        dao.delete(productCategory1)

        val afterDelete = dao.getAllCategory().first()

        Assert.assertThat(afterDelete.size, Matchers.equalTo(2))

    }

    @Test
    fun fDeleteAllCategory() = runBlocking {
        dao.deleteAllFromCategory()

        val afterDelete = dao.getAllCategory().first()

        Assert.assertThat(afterDelete.size, Matchers.equalTo(0))

    }






}