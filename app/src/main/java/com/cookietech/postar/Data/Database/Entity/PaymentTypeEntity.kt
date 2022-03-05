package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "payment_type_table"
)
data class PaymentTypeEntity(
    val payment_type:String
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
