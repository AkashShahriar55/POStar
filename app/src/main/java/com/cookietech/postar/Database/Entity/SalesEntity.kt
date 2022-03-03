package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class SalesEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val invoice_id:Int,
    val product_id:Int,
    val quantity:Float,
    val unit_price:Float,
    val sub_total:Float
)
