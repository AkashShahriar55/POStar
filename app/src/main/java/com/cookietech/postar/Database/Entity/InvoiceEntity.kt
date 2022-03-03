package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity
data class InvoiceEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val customer_id:Int,
    val payment_type:Int,
    val total_amount:Float,
    val amount_tendered:Float,
    val bank_account_name:String,
    val bank_account_number:String,
    val date_recorded:Calendar = Calendar.getInstance(),
    val user_id:Int
)
