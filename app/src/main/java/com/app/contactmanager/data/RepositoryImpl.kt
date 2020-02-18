package com.app.contactmanager.data

import com.app.contactmanager.data.remote.ApiService
import com.app.contactmanager.data.remote.response.ContactResponse

class RepositoryImpl(private val apiService: ApiService) {
    suspend fun fetchContacts(): List<ContactResponse.Contact> {
        val data = mapOf(
            "page" to "1",
            "results" to "10",
            "seed" to "abc"
        )
        val response = apiService.fetchContacts(data)

        if (!response.isSuccessful) {
            return emptyList()
        }

        if (response.body() == null) {
            return emptyList()
        }

        return response.body()!!.results
    }
}