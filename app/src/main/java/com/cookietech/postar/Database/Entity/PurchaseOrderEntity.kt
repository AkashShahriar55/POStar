package com.cookietech.postar.Database.Entity

import java.util.*


data class PurchaseOrderEntity(
    val id:Int,
    val product_id:Int,
    val quantity:Float,
    val unit_price:Float,
    val sub_total:Float,
    val supplier_id:Int,
    val order_date:Calendar = Calendar.getInstance(),
    val is_received:Boolean,
    val received_date:Calendar = Calendar.getInstance(),
    val user_id:Int
)
