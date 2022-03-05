package com.cookietech.postar.Domain.UseCases

import com.cookietech.postar.Domain.Model.CustomerEntity
import com.cookietech.postar.Domain.Repository.CustomerRepository
import kotlinx.coroutines.flow.Flow

class AddCustomerUseCase(
    private val customerRepository: CustomerRepository
) {
    fun findCustomer(query:String): Flow<List<CustomerEntity>>{
        return customerRepository.searchCustomer(query)
    }

    fun createCustomer(customerEntity: CustomerEntity){
        customerRepository.createCustomer(customerEntity)
    }

}