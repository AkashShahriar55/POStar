package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "sales_table",
    foreignKeys = [
        ForeignKey(entity = InvoiceEntity::class,parentColumns = ["id"],childColumns = ["invoice_id"]),
        ForeignKey(entity = ProductEntity::class,parentColumns = ["id"],childColumns = ["product_id"])
    ]
)
data class SalesEntity(

    val invoice_id:Int,
    val product_id:Int,
    val quantity:Float,
    val unit_price:Float,
    val sub_total:Float
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
