package com.tabibu.entities

import com.tabibu.model.models.Customer
import com.tabibu.model.models.CustomerDTO
import java.util.*
import kotlin.collections.ArrayList

interface CustomerFunctions {
    suspend fun allCustomers(): ArrayList<Customer>
    suspend fun customer(id: Int) : Customer
    suspend fun addCustomer(customer: CustomerDTO)
    suspend fun editCustomerInfo(customer: CustomerDTO, id: UUID)
    suspend fun deleteCustomer(id: UUID)

}