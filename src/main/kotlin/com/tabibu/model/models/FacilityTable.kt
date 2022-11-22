package com.tabibu.model.models

import org.jetbrains.exposed.sql.*

object FacilityTable : Table() {
    val id = uuid("id")
    val facility_name = varchar("name", length = 50) // Column<String>
    val branch = varchar("branch", length = 50)
    val password = varchar("password", length = 50) // Column<String>
    val cityId = (integer("city_id") references CityTable.id).nullable() // Column<Int?>
    val country = (integer("country_id") references CountriesTable.id).nullable()
    val ammenity = text("ammenity")
    val services = text("services")
    val licences = varchar("licences", length = 50)

    override val primaryKey = PrimaryKey(id, name = "Facility_ID")

}