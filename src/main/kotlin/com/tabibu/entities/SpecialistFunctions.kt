package com.tabibu.entities

interface SpecialistFunctions {
    suspend fun connectToPatient()
    suspend fun breakPatientLink()
    suspend fun connectToFacility()
    suspend fun breakFacilityLink()
    suspend fun recommendFacility()
    suspend fun sendPrescription()
    suspend fun sendMonitoringDocument()
    suspend fun allDocuments(): List<CustomerController>
    suspend fun singleDocument(id: Int): CustomerController?
    suspend fun addDocument(title: String, body: String): CustomerController?
    suspend fun deleteAllDocuments(id: Int, title: String, body: String): Boolean
    suspend fun deleteDocument(id: Int): Boolean
}