package kr.co.lion.roompractice.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// Flow builders
// 플로우를 생성하는 builder
fun main() = runBlocking<Unit> {
    (1..3).asFlow().collect {
            value -> println(value)
    }
}