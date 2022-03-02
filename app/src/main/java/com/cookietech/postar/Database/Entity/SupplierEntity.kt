package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "supplier_table")
data class SupplierEntity(
    @PrimaryKey(autoGenerate = true) var supplier_id:Int,
    var supplier_code:String,
    var supplier_name:String,
    var supplier_contact:String,
    var supplier_address:String,
    var supplier_email:String
)
