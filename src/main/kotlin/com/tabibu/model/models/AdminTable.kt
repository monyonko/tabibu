package com.tabibu.model.models

import org.jetbrains.exposed.sql.*
import java.util.*

data class Admin(
    val id: UUID,
    val branch: Char,
    val name: String,
    val password: Char,
    val city: Int,
    val country: Int
)
object AdminTable : Table() {
    val id = uuid("id") // Column<String>
    val branch = varchar("branch", length = 50)
    val name = varchar("name", length = 50) // Column<String>
    val password = varchar("password", length = 50) // Column<String>
    val cityId = (integer("city_id") references CityTable.id).nullable() // Column<Int?>
    val country = (integer("country_id") references CountriesTable.id).nullable()

    override val primaryKey = PrimaryKey(id, name = "AdminTable_ID")
}