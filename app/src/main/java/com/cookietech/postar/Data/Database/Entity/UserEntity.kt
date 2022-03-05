package com.cookietech.postar.Data.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    val username:String,
    val password:String,
    val fullname:String,
    val designation:Int,
    val contact:String,
    val account_type:Int
){
    @PrimaryKey(autoGenerate = true) var id:Int = 0
}
