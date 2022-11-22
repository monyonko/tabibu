package com.tabibu.model.models

import org.jetbrains.exposed.sql.*
import java.util.*

data class Documents(
    val id: UUID,
    val name: Char,
    val document : Char,
    val user_id : UUID

)
object DocumentsTable : Table(){
    val id = uuid("documentID")// Column<String>
    val name = varchar("name", length = 50) // Column<String>
    //string that stores the photo
    val document = varchar("document", length = 50) // Column<String>
    val user_id = (uuid("user_id") references CustomerTable.id).nullable()


    override val primaryKey = PrimaryKey(id, name = "Document_ID") // name is optional here
}