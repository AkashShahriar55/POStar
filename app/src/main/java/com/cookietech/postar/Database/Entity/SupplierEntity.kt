package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "supplier_table")
data class SupplierEntity(
    @PrimaryKey(autoGenerate = true) val id:Int,
    val supplier_code:String,
    val supplier_name:String,
    val supplier_contact:String,
    val supplier_address:String,
    val supplier_email:String
)
