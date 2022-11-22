package com.tabibu.model.models


import org.jetbrains.exposed.sql.*

object SpecialistTable : Table() {
    val id = uuid("id") // Column<String>
    val category = varchar("category", length=10)
    val name = varchar("name", length = 50) // Column<String>
    val username = varchar("username", length = 50) // Column<String>
    val email = varchar("email", length = 50) // Column<String>
    val password = varchar("password", length = 50) // Column<String>
    val licences = varchar("licence[s]", length = 50)
    val cityId = (integer("city_id") references CityTable.id).nullable() // Column<Int?>
    val country = (integer("country_id") references CountriesTable.id).nullable()
    val facility = (uuid("facility_id") references FacilityTable.id).nullable()

    override val primaryKey = PrimaryKey(id, name = "Facility_ID")


}