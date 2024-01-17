package kr.co.lion.roompractice.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// filter : 특정 값을 추출할 수 있습니다.
fun main() = runBlocking<Unit> {

    (1..5).asFlow()
        .filter {
            it % 2 == 0
        }.collect {
            println("Collect $it")
        }

}