package com.cookietech.postar.Domain.UseCases

import com.cookietech.postar.Domain.Model.CustomerEntity
import com.cookietech.postar.Domain.Repository.CustomerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cache

class AddCustomerUseCase(
    private val customerRepository: CustomerRepository
) {

    fun findCustomer(query:String): Flow<List<CustomerEntity>>{
        return customerRepository.searchCustomer(query)
    }

    fun createCustomer(customerEntity: CustomerEntity){
        customerRepository.createCustomer(customerEntity)
    }

    fun updateCustomer(customerEntity: CustomerEntity){
        customerRepository.updateCustomer(customerEntity)
    }

    fun deleteCustomer(customerEntity: CustomerEntity){
        customerRepository.deleteCustomer(customerEntity)
    }

    fun getCustomer(id:String){
        customerRepository.getCustomerById(id)
    }

    fun getAllCustomer():Flow<List<CustomerEntity>> = customerRepository.getAllCustomers()

}