package com.tabibu.model.models


import com.tabibu.model.models.DocumentsTable.nullable
import com.tabibu.model.models.DocumentsTable.references
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.jodatime.datetime
import org.joda.time.DateTime
import java.util.*

data class Complaint(
    val id: UUID,
    val name: String,
    val complaint:String,
    val user_id: UUID,
    val timestamp: DateTime,
    val city: Int,
    val country: Int
)
object ComplaintsTable : Table() {
    val id = uuid("id") // Column<Int>
    val name = varchar("name", length = 50) // Column<String>
    val complaint = text("complaint")
    val timestamp = datetime("date")
    val user_id = (uuid("user_id") references CustomerTable.id).nullable()
    val city = (integer("country_id") references CityTable.id).nullable()
    val country = (integer("country_id") references CountriesTable.id).nullable()


    override val primaryKey = PrimaryKey(CustomerTable.id, name = "City_ID") // name is optional here
}