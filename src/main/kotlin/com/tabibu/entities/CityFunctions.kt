package com.tabibu.entities

interface CityFunctions {
    suspend fun allCities(): List<CustomerController>
    suspend fun city(id: Int): CustomerController?
    suspend fun addCity(title: String, body: String): CustomerController?
    suspend fun suspendCity(id: Int): Boolean
}