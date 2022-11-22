package com.tabibu.entities

interface AdminFunctions {
    suspend fun suspendAccount()
    suspend fun suspendFacility()
    suspend fun approveFacility()
    suspend fun approveSpecialist()
    suspend fun viewComplaint()
    suspend fun allComplaints()
    suspend fun handledComplaints()
    suspend fun unhandledComplaints()
}
