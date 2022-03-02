package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cookietech.postar.Model.ProductCategory

@Entity(tableName = "product_category_table")
data class ProductCategoryEntity(
    @PrimaryKey(autoGenerate = true) var category_id:Int,
    var category_name:String
):ProductCategory {
    override fun getCategoryId(): Int {
        return category_id
    }

    override fun getCategoryName(): String {
        return category_name
    }
}
