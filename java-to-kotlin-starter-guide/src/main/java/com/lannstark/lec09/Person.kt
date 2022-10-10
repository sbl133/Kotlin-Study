package com.lannstark.lec09

fun main() {
    val person = Person()
    println(person.name)
    person.age = 10
    println(person.age)
}

class Person(
    val name: String,
    var age: Int
) {
    init{
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다.")
        }
        println("초기화 블록")
    }

    constructor(name: String): this(name, 1){
        println("부생성자 1")
    }

    constructor() : this("이승범"){
        println("부생성자 2")
    }

//    fun isAdult(): Boolean{
//        return this.age >= 20
//    }

    val isAdult: Boolean
        get() = this.age >= 20
}