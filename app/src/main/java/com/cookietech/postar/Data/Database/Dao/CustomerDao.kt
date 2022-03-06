package com.cookietech.postar.Data.Database.Dao

import androidx.room.Dao
import androidx.room.Query
import com.cookietech.postar.Domain.Model.CustomerEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class CustomerDao: BaseDao<CustomerEntity>() {

    @Query("select * from customer_table")
    abstract fun getAllCustomers(): Flow<List<CustomerEntity>>

    @Query("select * from customer_table where id = :id")
    abstract fun getCustomerById(id: String): Flow<CustomerEntity>

    @Query(
        "select * from customer_table where customer_name like :query"
    )
    abstract fun searchCustomer(query: String): Flow<List<CustomerEntity>>

}