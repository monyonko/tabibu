package com.tabibu.entities

interface DocumentFunctions {
    suspend fun allDocuments(): List<CustomerController>
    suspend fun singleDocument(id: Int): CustomerController?
    suspend fun addDocument(title: String, body: String): CustomerController?
    suspend fun deleteAllDocuments(id: Int, title: String, body: String): Boolean
    suspend fun deleteDocument(id: Int): Boolean
}