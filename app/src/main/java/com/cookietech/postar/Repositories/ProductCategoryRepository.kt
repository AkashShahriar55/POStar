package com.cookietech.postar.Repositories

import androidx.annotation.WorkerThread
import com.cookietech.postar.Data.Database.Dao.ProductCategoryDao
import com.cookietech.postar.Data.Database.Entity.ProductCategoryEntity
import kotlinx.coroutines.flow.Flow

class ProductCategoryRepository(private val productCategoryDao: ProductCategoryDao) {

    val allCategory: Flow<List<ProductCategoryEntity>> = productCategoryDao.getAllCategory()


    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(productCategory:ProductCategoryEntity){
        productCategoryDao.insert(productCategory)
    }
}