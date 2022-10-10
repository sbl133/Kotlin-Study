package com.lannstark.lec10

fun main(){
    Derived(300)
}
open class Base(
    open val number: Int = 100
) {
    init {
        println("Base Class")
        println(number) // 하위 클래스의 number property가 초기화 되기전에 호출
    }
}

class Derived(
    override val number: Int
) : Base(number){
    init {
        println("Derived Class")
    }
}