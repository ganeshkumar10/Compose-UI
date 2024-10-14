package com.example.blogapplication.livedata

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.blogapplication.R

class LiveDataActivity : AppCompatActivity() {

    lateinit var edUserNumber: EditText
    private lateinit var btnNumber: Button
    private lateinit var liveDataViewModel: LiveDataViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        edUserNumber = findViewById(R.id.edtUserNumber)
        btnNumber = findViewById(R.id.btnNumber)
        liveDataViewModel = ViewModelProvider(this)[LiveDataViewModel::class.java]

        btnNumber.setOnClickListener {
            liveDataViewModel.startTimer()
        }

        liveDataViewModel.seconds().observe(this) {
            btnNumber.text = it.toString()
        }
        liveDataViewModel.isFinished.observe(this) {
            if (it) {
                Toast.makeText(this, "Finished", Toast.LENGTH_SHORT).show()
            }
        }
    }
}