package com.cookietech.postar.Data.Repository.DataSource

import com.cookietech.postar.Domain.Model.CustomerEntity
import com.cookietech.postar.Domain.Model.Status
import kotlinx.coroutines.flow.Flow


interface CustomerLocalDataSource {
    fun createCustomer(customer:CustomerEntity)
    fun getAllCustomers():Flow<List<CustomerEntity>>
    fun getCustomerById(id:String):Flow<CustomerEntity>
    fun searchCustomer(query:String):Flow<List<CustomerEntity>>
    fun updateCustomer(customer: CustomerEntity):Flow<Status>
}