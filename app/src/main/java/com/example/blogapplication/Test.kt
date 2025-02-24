package com.example.blogapplication

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): kotlin.Unit = runBlocking {
    launch() {
        println("Task 1 - Running on: ${Thread.currentThread().name}")
        delay(10000)
        println("Task 1 - Completed")
    }

    launch() {
        println("Task 2 - Running on: ${Thread.currentThread().name}")
        delay(5000)
        println("Task 2 - Completed")
    }

    CoroutineScope(Dispatchers.Main).launch {
        val file1 = async(Dispatchers.IO) { downloadFile("Name.pdf") }
        val result = file1.await()
        println(result)
    }

}

suspend fun downloadFile(name: String): String {
    delay(2000)
    return "Downloaded success : $name"
}
