package kr.co.lion.roompractice.flow

// Flow 는 Cold Stream 이다
// StateFlow는 Hot Stream 이다.
// Cold Stream -> 수도꼭지 -> 내가 틀면 물이 나온다
// Hot Stream -> 냇가(계곡) -> 그냥 물이 흐르고 있다

// Flow는 값을 collect할 때 마다 처음부터 생성하지만
// StateFlow는 항상 어떤 값을 가져야 하며 그 값은
// 항상 최신 값이다.

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

class StateFlowExample {

    var stFlow: MutableStateFlow<Int> = MutableStateFlow(0)

    suspend fun hot() {
        for (i in 1..3) {
            delay(100)
            stFlow.value = i
        }
    }

    fun cold(): Flow<Int> = flow {
        println("Flow started")
        for (i in 1..3) {
            delay(100)
            emit(i)
        }
    }
}

fun main() = runBlocking<Unit> {
    val ex = StateFlowExample()

    println("Calling flow...")
    val flow = ex.cold()
    println("Calling flow collect...")
    flow.collect {
            value -> println(value)
    }

    println("===========================")
    println("Calling StateFlow...")
    ex.hot()
    println("Calling StateFlow collect...")
    ex.stFlow.collect { value ->
        println("StateFlow collected: $value")
    }

}