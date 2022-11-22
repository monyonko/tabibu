package com.tabibu.entities

import com.tabibu.model.models.Customer
import com.tabibu.model.models.CustomerDTO
import com.tabibu.model.models.CustomerTable
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*
import kotlin.collections.ArrayList

class CustomerController : CustomerFunctions{

    override suspend fun allCustomers(): ArrayList<Customer> {
        val customers: ArrayList<Customer> = arrayListOf()
        transaction {
            CustomerTable.selectAll().map {
                customers.add(
                    Customer(
                        id = it[CustomerTable.id],
                        name = it[CustomerTable.name],
                        username = it[CustomerTable.username],
                        email = it[CustomerTable.email],
                        password = it[CustomerTable.password],
                        city = it[CustomerTable.city],
                        country = it[CustomerTable.country],
                        documents = it[CustomerTable.documents]
                    )
                )
            }
        }
        return customers
    }

    override suspend fun customer(id: Int): Customer {
        TODO("Not yet implemented")
    }


    override suspend fun addCustomer(customer: CustomerDTO) {
        transaction {
            CustomerTable.insert {
                it[id] = UUID.randomUUID()
                it[name] = customer.name
                it[username] = customer.username
                it[email] = customer.email
                it[password] = customer.password
            }
        }
    }

    override suspend fun editCustomerInfo(customer: CustomerDTO, id: UUID) {
        transaction {
            CustomerTable.update({CustomerTable.id eq id}) {
                it[name] = customer.name
                it[username] = customer.username
                it[email] = customer.email
                it[password] = customer.password

            }
        }
    }

    override suspend fun deleteCustomer (id: UUID) {
        transaction {
            CustomerTable.deleteWhere { CustomerTable.id eq id }
        }
    }




}
