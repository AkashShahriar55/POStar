package com.cookietech.postar.Data.Database.Dao

import androidx.room.*
import com.cookietech.postar.Data.Database.Entity.ProductCategoryEntity
import com.cookietech.postar.Data.Database.Entity.ProductUnitEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class ProductUnitDao: BaseDao<ProductUnitEntity>() {

    @Query("delete from product_unit_table")
    abstract fun deleteAllFromCategory()

    @Query("select * from product_unit_table order by unit_name desc")
    abstract fun getAllCategory(): Flow<List<ProductUnitEntity>>



}