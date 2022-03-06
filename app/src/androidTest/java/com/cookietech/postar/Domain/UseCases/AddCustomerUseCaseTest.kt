package com.cookietech.postar.Domain.UseCases

import android.util.Log
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.cookietech.postar.Data.Database.Databases.AppDatabase
import com.cookietech.postar.Data.Repository.CustomerRepositoryImpl
import com.cookietech.postar.Data.Repository.DataSourceImpl.CustomerLocalDataSourceImpl
import com.cookietech.postar.Data.Repository.DataSourceImpl.CustomerRemoteDataSourceImpl
import com.cookietech.postar.Domain.Model.CustomerEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@SmallTest
class AddCustomerUseCaseTest {
    lateinit var addCustomerUseCase: AddCustomerUseCase

    val customer1 = CustomerEntity("as100","Akash Shahriar","+8801879079252","Nikunja 2")
    val customer2 = CustomerEntity("bi101","Bishal Imtiaz","+8801776733337","Nikunja 2")
    val customer3 = CustomerEntity("sr102","Shohanur Rahman","+8801718326446","Nikunja 2")

    val customer4 = CustomerEntity("ms102","Muit Showrov","+8801757675868","Nikunja 2")

    @Before
    fun before(){
        val database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            AppDatabase::class.java
        ).build()
        val customerLocalDataSourceImpl = CustomerLocalDataSourceImpl(database)
        val customerRemoteDataSourceImpl = CustomerRemoteDataSourceImpl()
        val customerRepository = CustomerRepositoryImpl(customerLocalDataSourceImpl = customerLocalDataSourceImpl,customerRemoteDataSourceImpl = customerRemoteDataSourceImpl)
        addCustomerUseCase = AddCustomerUseCase(customerRepository);

        addCustomerUseCase.createCustomer(customer1)
        addCustomerUseCase.createCustomer(customer2)
        addCustomerUseCase.createCustomer(customer3)
    }

    @Test
    fun addCustomer() = runBlocking{
        addCustomerUseCase.createCustomer(customer4)

        val customers = addCustomerUseCase.getAllCustomer().first()

        Assert.assertThat(customers.size, Matchers.equalTo(4))

        Assert.assertThat(customers[3], Matchers.equalTo(customer4))
    }


    @Test
    fun updateCustomer() = runBlocking {
        var customers = addCustomerUseCase.getAllCustomer().first()


        Log.d("customer_use_case", "updateCustomer: $customers")

        Assert.assertThat(customers.size, Matchers.equalTo(3))


        customer4.id = customers[0].id

        addCustomerUseCase.updateCustomer(customer4)

        customers = addCustomerUseCase.getAllCustomer().first()

        Assert.assertThat(customers.size, Matchers.equalTo(3))

        Assert.assertThat(customers[0], Matchers.equalTo(customer4))


    }

    @Test
    fun deleteCustomer() = runBlocking {
        var customers = addCustomerUseCase.getAllCustomer().first()


        Log.d("customer_use_case", "updateCustomer: $customers")

        Assert.assertThat(customers.size, Matchers.equalTo(3))


        addCustomerUseCase.deleteCustomer(customers[0])

        customers = addCustomerUseCase.getAllCustomer().first()
        Log.d("customer_use_case", "updateCustomer: $customers")

        Assert.assertThat(customers.size, Matchers.equalTo(2))

        Assert.assertThat(customers[0], Matchers.equalTo(customer2))


    }

    @After
    fun after(){

    }


}