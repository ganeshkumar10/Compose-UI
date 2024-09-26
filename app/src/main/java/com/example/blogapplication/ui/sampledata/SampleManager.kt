package com.example.blogapplication.ui.sampledata

import android.util.Log

object SampleManager {

    private val sampleList = mutableListOf<SampleData>()
    private var countNUmber = 0

    fun getAllSamples(): List<SampleData> {
        return sampleList
    }

    fun addAllSamples(name: String) {
        countNUmber +=1
        Log.v("namenumber", countNUmber.toString())
        sampleList.add(SampleData(countNUmber, name, 10, "Male"))
    }

    fun deleteAllSamples(id: Int) {
        sampleList.removeIf {
            it.id == id
        }
    }

}