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
        return customerDao.getAllCustomers()
    }

    override fun getCustomerById(id: String): Flow<CustomerEntity> {
        return customerDao.getCustomerById(id)
    }

    override fun searchCustomer(query: String): Flow<List<CustomerEntity>> {
        return customerDao.searchCustomer(query)
    }

    override fun updateCustomer(customer: CustomerEntity) {
        customerDao.update(customer)
    }

    override fun deleteCustomer(customer: CustomerEntity) {
        val result = customerDao.delete(customer)
        Log.d("customer_use_case", "deleteCustomer: $result")
    }
}