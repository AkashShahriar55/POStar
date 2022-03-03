package com.cookietech.postar.Database.Dao

import androidx.room.*
import com.cookietech.postar.Database.Entity.ProductCategoryEntity
import com.cookietech.postar.Model.ProductCategory
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductCategoryDao {


    @Insert(onConflict =  OnConflictStrategy.REPLACE)
    fun insert(productCategory: ProductCategoryEntity)

    @Update
    fun update(productCategory: ProductCategoryEntity)

    @Delete
    fun delete(productCategory: ProductCategoryEntity)

    @Query("delete from product_category_table")
    fun deleteAllFromCategory()

    @Query("select * from product_category_table order by category_name")
    fun getAllCategory(): Flow<List<ProductCategoryEntity>>

    @Query("select * from product_category_table where id = :id")
    fun getCategoryById(id:Int):Flow<ProductCategoryEntity>

}