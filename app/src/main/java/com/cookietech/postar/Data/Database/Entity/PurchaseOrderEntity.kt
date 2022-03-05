package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*


@Entity(
    tableName = "purchase_order_entity",
    foreignKeys = [
        ForeignKey(entity = ProductEntity::class,parentColumns = ["id"],childColumns = ["product_id"]),
        ForeignKey(entity = SupplierEntity::class,parentColumns = ["id"],childColumns = ["supplier_id"]),
        ForeignKey(entity = UserEntity::class,parentColumns = ["id"],childColumns = ["user_id"])
    ]
)
data class PurchaseOrderEntity(

    val product_id:Int,
    val quantity:Float,
    val unit_price:Float,
    val sub_total:Float,
    val supplier_id:Int,
    val order_date:Calendar = Calendar.getInstance(),
    val is_received:Boolean,
    val received_date:Calendar = Calendar.getInstance(),
    val user_id:Int
){
    @PrimaryKey var id:Int = 0
}
