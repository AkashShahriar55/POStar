package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_table")
data class CustomerEntity(
    @PrimaryKey(autoGenerate = true) var customer_id:Int,
    var customer_code:String,
    var customer_name:String,
    var contact:String,
    var address:String
)
