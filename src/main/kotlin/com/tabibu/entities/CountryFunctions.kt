package com.tabibu.entities

interface CountryFunctions {
    suspend fun allCountries(): ArrayList<CountryController>
    suspend fun country(id: Int): CountryController
    suspend fun addCountry()
    suspend fun suspendCountry(id: Int)
}