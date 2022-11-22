package com.tabibu.model.models

import org.jetbrains.exposed.sql.*

data class Country(
    val id: Int,
    val name: String
)
object CountriesTable : Table(){
    val id = integer("id").autoIncrement() // Column<Int>
    val name = varchar("name", length = 50) // Column<String>

    override val primaryKey = PrimaryKey(CountriesTable.id, name = "Country_ID")
}