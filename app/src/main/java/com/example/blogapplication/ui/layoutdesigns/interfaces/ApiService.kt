package com.example.blogapplication.ui.layoutdesigns.interfaces

import retrofit2.http.GET


data class ApiResponse(val id: Int, val title: String, val body: String)

interface ApiService {
    @GET("posts/1") // Dummy API endpoint (JSONPlaceholder)
    suspend fun getPost(): ApiResponse
}