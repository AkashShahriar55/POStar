package com.cookietech.postar.Domain.Model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class CustomerEntity(
    val customer_code:String,
    val customer_name:String,
    val contact:String,
    val address:String
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
