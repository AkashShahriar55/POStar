package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.cookietech.postar.Domain.Model.CustomerEntity
import java.util.*


@Entity(
    tableName = "invoice_table",
    foreignKeys = [
        ForeignKey(entity = CustomerEntity::class,parentColumns = ["id"],childColumns = ["customer_id"]),
        ForeignKey(entity = CustomerEntity::class,parentColumns = ["id"],childColumns = ["user_id"]),
        ForeignKey(entity = CustomerEntity::class,parentColumns = ["id"],childColumns = ["payment_type"])
    ],
    indices = [
        Index("date_recorded")
    ]
)
data class InvoiceEntity(
    val customer_id:Int,
    val payment_type:Int,
    val total_amount:Float,
    val amount_tendered:Float,
    val bank_account_name:String,
    val bank_account_number:String,
    val date_recorded:Calendar = Calendar.getInstance(),
    val user_id:Int
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
