package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "supplier_table",
)
data class SupplierEntity(
    val supplier_code:String,
    val supplier_name:String,
    val supplier_contact:String,
    val supplier_address:String,
    val supplier_email:String
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
