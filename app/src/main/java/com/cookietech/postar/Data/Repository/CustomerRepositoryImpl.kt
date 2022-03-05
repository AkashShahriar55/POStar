package com.cookietech.postar.Data.Repository

import com.cookietech.postar.Data.Repository.DataSourceImpl.CustomerLocalDataSourceImpl
import com.cookietech.postar.Data.Repository.DataSourceImpl.CustomerRemoteDataSourceImpl
import com.cookietech.postar.Domain.Model.CustomerEntity
import com.cookietech.postar.Domain.Model.Status
import com.cookietech.postar.Domain.Repository.CustomerRepository
import kotlinx.coroutines.flow.Flow

class CustomerRepositoryImpl(
    private val customerRemoteDataSourceImpl: CustomerRemoteDataSourceImpl,
    private val customerLocalDataSourceImpl: CustomerLocalDataSourceImpl
):CustomerRepository {
    override fun createCustomer(customer: CustomerEntity)= customerLocalDataSourceImpl.createCustomer(customer)

    override fun getAllCustomers(): Flow<List<CustomerEntity>> = customerLocalDataSourceImpl.getAllCustomers()

    override fun getCustomerById(id: String): Flow<CustomerEntity> = customerLocalDataSourceImpl.getCustomerById(id)

    override fun searchCustomer(query: String): Flow<List<CustomerEntity>> = customerLocalDataSourceImpl.searchCustomer(query)

    override fun updateCustomer(customer: CustomerEntity): Flow<Status> =  customerLocalDataSourceImpl.updateCustomer(customer)
}