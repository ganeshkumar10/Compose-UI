package com.example.blogapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.blogapplication.ui.sampledata.SampleData
import com.example.blogapplication.ui.sampledata.SampleManager

class SampleViewModel : ViewModel() {

    private var _sampleList = MutableLiveData<List<SampleData>>()

    val sampleList: LiveData<List<SampleData>> = _sampleList

    private fun getAllSamples() {
        _sampleList.value = SampleManager.getAllSamples().reversed()
    }

    fun addAllSamples(name: String) {
        SampleManager.addAllSamples(name)
        getAllSamples()
    }

    fun deleteAllSamples(number: Int) {
        SampleManager.deleteAllSamples(number)
        getAllSamples()
    }

}