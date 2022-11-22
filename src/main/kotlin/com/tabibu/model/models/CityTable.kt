package com.tabibu.model.models

import org.jetbrains.exposed.sql.*

data class City(
    val id: Int,
    val name: String,
    val country: Int,
)
object CityTable : Table() {
    val id = integer("id").autoIncrement() // Column<Int>
    val name = varchar("name", length = 50) // Column<String>
    val country = (integer("country_id") references CountriesTable.id).nullable()

    override val primaryKey = PrimaryKey(CityTable.id, name = "City_ID")
}