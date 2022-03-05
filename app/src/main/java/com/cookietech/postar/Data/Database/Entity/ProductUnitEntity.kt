package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_unit_table")
data class ProductUnitEntity(
        val unit_name:String
    ){
    @PrimaryKey(autoGenerate = true)var id:Int = 0
}
