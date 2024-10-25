package com.example.blogapplication.interview

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.lang.reflect.Type
import java.util.Date


class ValidateConst() {
    fun textValWithoutConst() {
        val name = Constants.name
    }

    fun textWithConst() {
        val name = Constants.newName
    }
}

fun main() {
    /*reified*/
    /*val userJson = "{\"name\":\"Ganesh\"}"
    val userType = object : TypeToken<User>() {}.type
    val user = Gson().fromJson<User>(userJson)
    println(user.name)*/

    /*inline function*/
//    greet {
//        println("How are you?")
//    }
    /*reified*/
//    printType<String>("GANESH")
//    printType<Int>(0)

    runBlocking {
        println("Fetching...")
//        Thread.sleep(2000)
        val data = fetchUserData()  // Suspends without blocking the thread
        println("Data received: $data")
        println("Success data")
    }

}

suspend fun fetchUserData(): String {
    delay(5000)
    return "GANESHKUMAR"
}

inline fun greet(function: () -> Unit) {
    println("Hai")
    function()
    println("Ganesh")
}

inline fun <reified T> printType(value: Any) {
    if (value is T) {
        println("The value is of type ${T::class.simpleName}")
    } else {
        println("The value is not of type ${T::class.simpleName}")
    }
}


private inline fun <reified T> Gson.fromJson(userJson: String): T {
    return fromJson(userJson, object : TypeToken<T>() {}.type)
}

object Constants {
    val name = "Ganesh"
    const val newName = "Dinesh"
}

data class User(val name: String)

open class Ganesh() {
    open var name = "Ganesh"
}

class Abi() : Ganesh() {
    override var name = "Ganesh"
}

object AppUtils {
    @JvmStatic
    fun install() {
    }
}


class Ganeshkumar() {

}

class Abinaya() {

}

class Shenba() : Ganesh() {

}

val name = AppUtils.install()

val testing = Testing()
val newName = testing.userName()


data class Session @JvmOverloads constructor(val name: String, val date: Date = Date())

val sessionOne = Session("Gane", Date())
val sessionTwo = Session("Dinesh")

data class SessionNew @JvmOverloads constructor(val name: String, val gender: String)

val sessionNew = SessionNew("Mathan","A")
//val sessionNewTwo = SessionNew("Mathan")
