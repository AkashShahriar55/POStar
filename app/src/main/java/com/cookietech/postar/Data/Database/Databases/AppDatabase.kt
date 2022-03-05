package com.cookietech.postar.Data.Database.Databases

import android.content.Context
import androidx.room.*
import com.cookietech.postar.Data.Database.Dao.CustomerDao
import com.cookietech.postar.Data.Database.Dao.ProductCategoryDao
import com.cookietech.postar.Data.Database.Entity.*
import com.cookietech.postar.Data.Database.Utils.Converters
import com.cookietech.postar.Domain.Model.CustomerEntity

@Database(
    entities = [
        CustomerEntity::class,
        InvoiceEntity::class,
        PaymentTypeEntity::class,
        ProductCategoryEntity::class,
        ProductEntity::class,
        ProductUnitEntity::class,
        PurchaseOrderEntity::class,
        SalesEntity::class,
        SupplierEntity::class,
        UserEntity::class
               ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase:RoomDatabase() {

    abstract val productCategoryDao:ProductCategoryDao
    abstract val customerDao:CustomerDao

    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null)
                {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "pos_database"
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