package com.cookietech.postar.Database.Databases

import android.content.Context
import androidx.room.*
import com.cookietech.postar.Database.Dao.ProductCategoryDao
import com.cookietech.postar.Database.Entity.ProductCategoryEntity

@Database(entities = [ProductCategoryEntity::class],version = 1,exportSchema = false)
abstract class ProductCategoryDatabase:RoomDatabase() {

    abstract val productCategoryDao:ProductCategoryDao

    companion object{

        @Volatile
        private var INSTANCE: ProductCategoryDatabase? = null

        fun getInstance(context: Context): ProductCategoryDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductCategoryDatabase::class.java,
                        "product_category_database"
                    )
                        .fallbackToDestructiveMigration()// if migrate the data will be lost . need to implement differently
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }


}