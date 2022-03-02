package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cookietech.postar.Model.ProductUnit

@Entity(tableName = "product_unit_table")
data class ProductUnitEntity(
        @PrimaryKey(autoGenerate = true)var unit_id:Int,
        var unit_name:String
    ):ProductUnit{
    override fun getUnitId(): Int {
        return unit_id
    }

    override fun getUnitName(): String {
        return unit_name
    }

}