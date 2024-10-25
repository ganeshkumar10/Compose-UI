package com.example.blogapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.blogapplication.interview.ValidateConst
import com.example.blogapplication.ui.theme.BlogApplicationTheme
import com.example.blogapplication.ui.viewmodel.SampleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sampleViewModel = ViewModelProvider(this)[SampleViewModel::class.java]
        setContent {
            BlogApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    CreateNewSampleData(sampleViewModel)
                    ValidateConst()
                }
            }
        }
    }
}


