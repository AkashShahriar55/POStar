package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) var id:Int,
    var username:String,
    var password:String,
    var fullname:String,
    var designation:Int,
    var contact:String,
    var account_type:Int
)
