package com.cookietech.postar.Data.Database.Databases

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.cookietech.postar.Data.Database.Dao.CustomerDao
import com.cookietech.postar.Data.Database.Dao.ProductCategoryDao
import com.cookietech.postar.Data.Database.Dao.ProductUnitDao
import com.cookietech.postar.Data.Database.Entity.*
import com.cookietech.postar.Data.Database.Utils.Converters
import com.cookietech.postar.Data.Worker.PrepopulateDbWorker
import com.cookietech.postar.Data.Worker.PrepopulateDbWorker.Companion.KEY_FILENAME
import com.cookietech.postar.Domain.Model.CustomerEntity
import com.cookietech.postar.UNIT_DATA_FILENAME

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
    abstract val productUnitDao:ProductUnitDao

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
                        .addCallback(DatabaseCreationCallback(context))// if migrate the data will be lost . need to implement differently
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }

        private class DatabaseCreationCallback(val context: Context): RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                val prepopulateRequest = OneTimeWorkRequestBuilder<PrepopulateDbWorker>()
                    .setInputData(workDataOf(KEY_FILENAME to UNIT_DATA_FILENAME))
                    .build();
                WorkManager.getInstance(context).enqueue(prepopulateRequest)
            }
        }
    }


}