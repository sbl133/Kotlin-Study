package com.lannstark.lec08

fun main() {
    repeat("asd") // default argument
    repeat("asd ", useNewLine = false, num = 5) // named argument

    printAll("a", "b", "c")

    val array = arrayOf("a", "b", "c")
    printAll(*array) // 배열을 가변인자에 넣을때는 spread 연산자 별표를 넣어주어야 함
}

fun max(a: Int, b: Int) = if (a > b) a else b

fun repeat(
    str: String,
    num: Int = 3,
    useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}