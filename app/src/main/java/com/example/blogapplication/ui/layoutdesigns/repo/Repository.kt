package com.example.blogapplication.ui.layoutdesigns.repo

import com.example.blogapplication.ui.layoutdesigns.interfaces.ApiResponse
import com.example.blogapplication.ui.layoutdesigns.interfaces.ApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {
    private val api: ApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(ApiService::class.java)
    }

    suspend fun fetchPost(): ApiResponse? {
        return withContext(Dispatchers.IO) {
            try {
                api.getPost()
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }
    }
}