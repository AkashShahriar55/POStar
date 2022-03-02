package com.cookietech.postar.Database.Dao

import androidx.room.*
import com.cookietech.postar.Database.Entity.ProductCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductCategoryDao {


    @Insert
    fun insert(productCategory: ProductCategoryEntity)

    @Update
    fun update(productCategory: ProductCategoryEntity)

    @Delete
    fun delete(productCategory: ProductCategoryEntity)

    @Query("delete from product_category_table")
    fun deleteAllFromCategory()

    @Query("select * from product_category_table order by category_name desc")
    fun getAllCategory(): Flow<List<ProductCategoryEntity>>

}