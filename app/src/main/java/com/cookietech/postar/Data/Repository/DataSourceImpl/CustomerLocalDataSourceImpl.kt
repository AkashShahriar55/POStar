package com.cookietech.postar.Data.Repository.DataSourceImpl

import android.util.Log
import com.cookietech.postar.Data.Database.Databases.AppDatabase
import com.cookietech.postar.Data.Repository.DataSource.CustomerLocalDataSource
import com.cookietech.postar.Domain.Model.CustomerEntity
import com.cookietech.postar.Domain.Model.Status
import kotlinx.coroutines.flow.Flow

class CustomerLocalDataSourceImpl(
    private val appDatabase: AppDatabase
):CustomerLocalDataSource {
    val customerDao = appDatabase.customerDao
    override fun createCustomer(customer: CustomerEntity) {
        val column = customerDao.insert(customer)
        Log.d(this.javaClass.name, "createCustomer: ")
    }

    override fun getAllCustomers(): Flow<List<CustomerEntity>> {
        TODO("Not yet implemented")
    }

    override fun getCustomerById(id: String): Flow<CustomerEntity> {
        TODO("Not yet implemented")
    }

    override fun searchCustomer(query: String): Flow<List<CustomerEntity>> {
        TODO("Not yet implemented")
    }

    override fun updateCustomer(customer: CustomerEntity): Flow<Status> {
        TODO("Not yet implemented")
    }
}