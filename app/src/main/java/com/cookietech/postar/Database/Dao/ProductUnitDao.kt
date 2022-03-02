package com.cookietech.postar.Database.Dao

import androidx.room.*
import com.cookietech.postar.Database.Entity.ProductCategoryEntity
import com.cookietech.postar.Database.Entity.ProductUnitEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductUnitDao {

    @Insert
    fun insert(productUnitEntity: ProductUnitEntity)

    @Update
    fun update(productUnitEntity: ProductUnitEntity)

    @Delete
    fun delete(productUnitEntity: ProductUnitEntity)

    @Query("delete from product_unit_table")
    fun deleteAllFromCategory()

    @Query("select * from product_unit_table order by unit_name desc")
    fun getAllCategory(): Flow<List<ProductCategoryEntity>>
}