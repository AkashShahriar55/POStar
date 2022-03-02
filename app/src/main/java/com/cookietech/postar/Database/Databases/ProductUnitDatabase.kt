package com.cookietech.postar.Database.Databases

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cookietech.postar.Database.Entity.ProductUnitEntity

@Database(entities = [ProductUnitEntity::class],version = 1,exportSchema = false)
abstract class ProductUnitDatabase:RoomDatabase() {


    abstract val productUnitEntity:ProductUnitEntity


    companion object{

        @Volatile
        private var INSTANCE:ProductUnitDatabase? = null

        fun getInstance(context: Context):ProductUnitDatabase{
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductUnitDatabase::class.java,
                        "product_unit_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }


    }

}