package com.app.contactmanager.data.remote

import com.app.contactmanager.data.remote.response.ContactResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface ApiService {
    @GET("api/")
    suspend fun fetchContacts(
        @QueryMap data: Map<String, String>
    ): Response<ContactResponse>
}