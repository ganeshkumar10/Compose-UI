package com.example.blogapplication.livedata

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    private lateinit var timer: CountDownTimer
    private val _seconds = MutableLiveData<Int>()
    var isFinished = MutableLiveData<Boolean>()

    fun seconds(): LiveData<Int> {
        return _seconds
    }

    fun startTimer() {
        timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(p0: Long) {
                val timeLeft = p0 / 1000
                _seconds.value = timeLeft.toInt()
            }

            override fun onFinish() {
                isFinished.value = true
            }
        }.start()
    }

    fun stopTimer() {
        timer.cancel()
    }

}