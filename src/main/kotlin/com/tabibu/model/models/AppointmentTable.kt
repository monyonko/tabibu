package com.tabibu.model.models

import com.tabibu.model.models.ComplaintsTable.nullable
import com.tabibu.model.models.ComplaintsTable.references
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime
import java.util.*


data class Appointment(
    val id: UUID,
    val name: String,
    val complaint:String,
    val user_id: UUID,
    val timestamp: DateTime,
    val city: Int,
    val country: Int
)
object AppointmentTable : Table() {
    val id = uuid("id") // Column<Int>
    val type = varchar("Appointment type", length=50)
    val facility = (uuid("facility_id") references FacilityTable.id).nullable()
    val ammenity = (uuid("ammenity"))
    val name = varchar("name", length = 50) // Column<String>
    val complaint = text("complaint")
    val timestamp = datetime("date")
    val user_id = (uuid("user_id") references CustomerTable.id).nullable()
    val city = (integer("country_id") references CityTable.id).nullable()
    val country = (integer("country_id") references CountriesTable.id).nullable()


    override val primaryKey = PrimaryKey(CustomerTable.id, name = "City_ID") // name is optional here
}

