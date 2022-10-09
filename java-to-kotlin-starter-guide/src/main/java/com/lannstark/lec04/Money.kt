package com.lannstark.lec04

import java.time.Month

data class Money (
    val amount: Long
){
    operator fun plus(other: Money): Money {
        return Money(this.amount + other.amount)
    }
}