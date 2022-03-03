package com.cookietech.postar.Database.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cookietech.postar.Model.ProductUnit

@Entity(tableName = "product_unit_table")
data class ProductUnitEntity(
        @PrimaryKey(autoGenerate = true)val id:Int,
        val unit_name:String
    ){
//    override fun getUnitId(): Int {
//        return id
//    }
//
//    override fun getUnitName(): String {
//        return unit_name
//    }


    constructor():this(0,""){}

}
