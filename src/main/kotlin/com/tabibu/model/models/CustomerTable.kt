package com.tabibu.model.models

import org.jetbrains.exposed.sql.*
import java.util.UUID


data class Customer(
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val username:String,
    val email: String,
    val password: String,
    val city: Int?,
    val country: Int?,
    val documents: UUID?
)
data class CustomerDTO(
    val name: String,
    val username:String,
    val email: String,
    val password: String,
    val city: Int?,
    val country: Int?,
    val documents: UUID?

)
object CustomerTable : Table() {
    val id = uuid("id")
    val name = varchar("name", length = 50) // Column<String>
    val username = varchar("username", length = 50) // Column<String>
    val email = varchar("email", length = 50) // Column<String>
    val password = varchar("password", length = 50) // Column<String>
    val city = (integer("city_id") references CityTable.id).nullable() // Column<Int?>
    val country = (integer("country_id") references CountriesTable.id).nullable()
    val documents = (uuid("document_id") references DocumentsTable.id).nullable()


    override val primaryKey = PrimaryKey(id, name = "Customer_ID") // name is optional here
}






