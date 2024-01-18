package kr.co.lion.roompractice.flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// suspend Function 예제
suspend fun foo(): List<Int>{
    delay(1000)
    return listOf(1,2,3)
}

fun main() = runBlocking {

    foo().forEach {
        println(it)
    }
}