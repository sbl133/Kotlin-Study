package com.lannstark.lec15

fun main() {
    var array = arrayOf(100, 200)

    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    array = array.plus(300)

    for ((idx, value) in array.withIndex()) {
        println("${idx} ${value}")
    }

    val numbers = listOf(100, 200)
    val emptyList = emptyList<Int>()

    printNumbers(emptyList()) // 메서드의 파라미터 타입으로 추록 가능하기 때문에 <>생략 가능

    println(numbers.get(0))
    println(numbers[0])

    for (number in numbers) {
        println(number)
    }

    for ((idx, value) in numbers.withIndex()) {
        println("$idx $value")
    }

    val mutableNumbers = mutableListOf(100)
    mutableNumbers.add(200)

    val oldMap = mutableMapOf<Int, String>()
    oldMap[1] = "MONDAY"
    oldMap[2] = "TUESDAY"

    for (key in oldMap.keys) {
        println(key)
        println(oldMap[key])
    }
    for ((key, value) in oldMap.entries) {
        println(key)
        println(value)
    }
    
    mapOf(1 to "MONDAY", 2 to "TUESDAY")
}

private fun printNumbers(numbers: List<Int>) {
    val mutableListOf = mutableListOf(100, 200)
    val value = mutableListOf.toList()
}