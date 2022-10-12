package com.lannstark.lec16

fun main() {
    val str = "ABC"
    println(str.lastChar())

    val b: A = B()
    b.print()

}

fun String.lastChar(): Char {
    return this[this.length -1]
}

open class A() {
    init {
        println("A")
    }

    open fun print(){
        println("AAA")
    }
}

class B() : A() {
    init {
        println("B")
    }

    override fun print(){
        println("BBB")
    }
}