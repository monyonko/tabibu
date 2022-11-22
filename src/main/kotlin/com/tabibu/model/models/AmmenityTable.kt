package com.tabibu.model.models

import com.tabibu.model.models.AdminTable.nullable
import com.tabibu.model.models.AdminTable.references
import com.tabibu.model.models.AdminTable.varchar
import org.jetbrains.exposed.sql.*
import java.util.*


class AmmenityTable : Table(){
    val id = uuid("id")
    val name = varchar("name", length=50)
    val specialty = varchar("specialty", length=50)
    val comments = text("comments")
    val specialist_id = (uuid("country_id") references FacilityTable.id).nullable()

    override val primaryKey = PrimaryKey(id, name = "AmmenityTable_ID")


}