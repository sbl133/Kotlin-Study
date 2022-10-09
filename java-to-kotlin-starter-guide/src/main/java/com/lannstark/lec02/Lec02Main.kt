package com.lannstark.lec02

fun main() {
    val str: String? = "ABC"
//    println(str.length) // null이 들어갈 수 있는 변수에는 .를 바로 못씀
    println(str?.length) // null이라면 전체가 null이된다.
    str?.length ?: 0 // Elvis 연산자 null이면 0이 됨

    println(startsWith(null)) // null이 아니라고 했는데 null이므로 runtimeEX 발생


    // @Nullable, @Notnull 같은 null에 대한 정보가 없는 자바코드에 대해서
    // kotlin은 null인지 아닌지 알수 없어 플랫폼 타입이 됨
    val person = Person(null)
    startsWithA(person.name)
}

fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}

fun starsWithA1(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다.")

//    if (str == null) {
//        throw IllegalArgumentException("null이 들어왔습니다.")
//    }
//    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? {
    return str?.startsWith("A")

//    if (str == null) {
//        return null
//    }
//    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    return str?.startsWith("A") ?: false

//    if (str == null) {
//        return false
//    }
//    return str.startsWith("A")
}

fun startsWith(str: String?): Boolean {
    return str!!.startsWith("A") // str이 절대 null이 될수 없다는것을 의미
}

