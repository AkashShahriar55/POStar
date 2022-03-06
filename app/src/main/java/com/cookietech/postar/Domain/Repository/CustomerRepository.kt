package com.cookietech.postar.Domain.Repository

import com.cookietech.postar.Domain.Model.CustomerEntity
import kotlinx.coroutines.flow.Flow

interface CustomerRepository {
    fun createCustomer(customer:CustomerEntity)
    fun getAllCustomers():Flow<List<CustomerEntity>>
    fun getCustomerById(id:String):Flow<CustomerEntity>
    fun searchCustomer(query:String):Flow<List<CustomerEntity>>
    fun updateCustomer(customer: CustomerEntity)
    fun deleteCustomer(customerEntity: CustomerEntity)
}