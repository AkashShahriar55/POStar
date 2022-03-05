package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "product_category_table",
    indices = [Index(value = ["category_name"],unique = true)]
)
data class ProductCategoryEntity(
    val category_name:String
) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
