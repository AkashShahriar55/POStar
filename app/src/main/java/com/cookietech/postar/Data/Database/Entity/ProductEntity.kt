package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "product_table",
    foreignKeys = [
        ForeignKey(entity = ProductUnitEntity::class,parentColumns = ["id"],childColumns = ["unit_id"]),
        ForeignKey(entity = ProductCategoryEntity::class,parentColumns = ["id"],childColumns = ["category_id"]),
        ForeignKey(entity = UserEntity::class,parentColumns = ["id"],childColumns = ["user_id"])
    ],
    indices = [
        Index(value = ["product_name"],unique = true),
        Index(value = ["unit_price"]),
        Index(value = ["unit_in_stock"])
    ]
)
data class ProductEntity(
    val product_code:String,
    val product_name:String,
    val unit_id:Int,
    val category_id:Int,
    val unit_in_stock:Float,
    val unit_price:Int,
    val user_id:Int,
    val bar_code:Int,
    val is_deleted:Boolean
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
