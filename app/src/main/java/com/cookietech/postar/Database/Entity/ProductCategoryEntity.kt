package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.cookietech.postar.Model.ProductCategory

@Entity(
    tableName = "product_category_table",
    indices = [Index(value = ["category_name"],unique = true)]
)
data class ProductCategoryEntity(
    val category_name:String
) {
    @PrimaryKey(autoGenerate = true) var id:Int = 0
//    override fun getCategoryId(): Int {
//        return id
//    }
//
//    override fun getCategoryName(): String {
//        return category_name
//    }

}
