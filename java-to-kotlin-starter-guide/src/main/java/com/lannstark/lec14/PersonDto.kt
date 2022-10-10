package com.lannstark.lec14

fun main(){
    val dto1 = PersonDto("이승범", 100)
    val dto2 = PersonDto("이승범", 100)
    println(dto1)
    println(dto1 == dto2)
}

data class PersonDto(
    val name: String,
    val age: Int
)