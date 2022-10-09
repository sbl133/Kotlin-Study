package com.lannstark.lec03

fun main() {
    val number1 = 3
    val number2: Long = number1.toLong()

    printAgeIfPerson3(null)
}

fun printAgeIfPerson1(obj: Any) {
    if (obj is Person) { // is는 java의 instanceof와 같은 기능
//        val person = obj as Person // java에서 (Person)처러 형변환 할때 as 사용
        println(obj.age) // but if에서 타입체크를 해줘서 as 생략가능
    }
}

fun printAgeIfPerson2(obj: Any?) {
    val person = obj as Person
    println(person.age)
}

fun printAgeIfPerson3(obj: Any?) {
    val person = obj as? Person
    println(person?.age)
}