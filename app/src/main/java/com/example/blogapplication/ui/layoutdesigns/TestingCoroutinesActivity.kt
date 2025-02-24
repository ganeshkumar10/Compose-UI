package com.example.blogapplication.ui.layoutdesigns

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.blogapplication.R
import com.example.blogapplication.ui.layoutdesigns.repo.Repository
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class TestingCoroutinesActivity : AppCompatActivity() {

    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing_coroutines)

        repository = Repository()
        fetchApiData()
    }

    private fun fetchApiData() {
        lifecycleScope.launch {
            Log.v("xx", "Starting API Call on ${Thread.currentThread().name}")
            val result = async { repository.fetchPost() }
            var apiResponse = result.await()
            if (apiResponse != null) {
                Log.v("xxxx", apiResponse.toString())
            } else {
                Log.v("xxxx", "API Response failed")
            }
            Log.v("xx", "Ending API Call on ${Thread.currentThread().name}")
        }
    }
}