package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_unit_table")
data class ProductUnitEntity(
        val unit_name:String,
        val unit_symbol:String,
        val unit_category:String
    ){
    @PrimaryKey(autoGenerate = true)var id:Int = 0
}
