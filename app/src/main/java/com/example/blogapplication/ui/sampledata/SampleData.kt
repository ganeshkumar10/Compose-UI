package com.example.blogapplication.ui.sampledata

data class SampleData(
    var id: Int,
    var name: String,
    var number: Long,
    var gender: String
)

fun getFakeData(): List<SampleData> {
    return listOf<SampleData>(
        SampleData(1, "Ganesh", 9159470370, "male"),
        SampleData(2, "Karthika", 8939222103, "female"),
        SampleData(3, "Selva", 8940488966, "male"),
        SampleData(4, "Abi", 9655283601, "female"),
        SampleData(5, "Shenbagaselvi", 9843356877, "female")
    )
}


