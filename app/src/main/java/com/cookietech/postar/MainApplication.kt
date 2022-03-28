package com.cookietech.postar

import android.app.Application
import androidx.lifecycle.asLiveData
import androidx.room.Room
import com.cookietech.postar.Data.Database.Databases.AppDatabase

open class MainApplication:Application() {

    lateinit var database:AppDatabase

    override fun onCreate() {
        super.onCreate()

        database = AppDatabase.getInstance(this)

        val units = database.productUnitDao.getAllCategory()


    }

}