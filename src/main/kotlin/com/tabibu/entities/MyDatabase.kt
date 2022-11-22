package com.tabibu.entities

import com.tabibu.model.models.*
import kotlinx.coroutines.Dispatchers
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction

object MyDatabase {
    fun init() {
        val driverClassName = "org.postgresql.Driver"
        val jdbcURL = "jdbc:postgresql://localhost:5432/tabibu"
        val user ="postgres"
        val password="borauhai"
        val database = Database.connect(jdbcURL, driverClassName, user, password)

        transaction(database) {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create (CityTable, CustomerTable, CountriesTable, FacilityTable, AdminTable, SpecialistTable)

        }
    }
    suspend fun <T> dbQuery(block: suspend () -> T): T =
        newSuspendedTransaction(Dispatchers.IO) { block() }

}