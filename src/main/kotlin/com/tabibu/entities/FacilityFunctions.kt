package com.tabibu.entities

interface FacilityFunctions {
    suspend fun allFacilities(): List<CustomerController>
    suspend fun facility(id: Int): CustomerController?
    suspend fun addFacility(title: String, body: String): CustomerController?
    suspend fun ammenitiesInFacility(id: Int, title: String, body: String): Boolean
    suspend fun servicesInFacility(id: Int): Boolean
    suspend fun suspendFacility()
    suspend fun suspendAmmenity()
}