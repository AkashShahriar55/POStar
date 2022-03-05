package com.cookietech.postar.Data.Database.Dao

import androidx.room.*
import com.cookietech.postar.Data.Database.Entity.ProductCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProductCategoryDao: BaseDao<ProductCategoryEntity>() {



    @Query("delete from product_category_table")
    abstract fun deleteAllFromCategory()

    @Query("select * from product_category_table order by category_name")
    abstract fun getAllCategory(): Flow<List<ProductCategoryEntity>>

    @Query("select * from product_category_table where id = :id")
    abstract fun getCategoryById(id:Int):Flow<ProductCategoryEntity>

}