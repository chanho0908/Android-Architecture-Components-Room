package kr.co.lion.roompractice.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple2(): Flow<Int> = flow {
    for (i in 1..3){
        delay(100)
        println("delay(100)")
        emit(i)
    }
}

fun main() = runBlocking{
    simple2().collect{
        println(it)
    }
}