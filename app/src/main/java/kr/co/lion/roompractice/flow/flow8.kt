package kr.co.lion.roompractice.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// collectLatest : 가장 최신(마지막) 값을 가져옵니다.
//
fun main() = runBlocking<Unit> {

    flow {
        emit(1)
        delay(50)
        emit(2)
    }.collectLatest { value ->
        println("Collecting $value")
        // delay(30) // Emulate work
        delay(80) // Emulate work
        println("$value collected")
    }

}