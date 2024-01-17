package kr.co.lion.roompractice.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

// map : Flow에서 생성된 데이터를 사용자가 원하는대로 가공
suspend fun performRequest(request: Int): String {
    delay(1000) // imitate long-running asynchronous work
    val cnt = request * request
    return "$cnt"
}

fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .map {
                request -> performRequest(request)
        }
        .collect {
                response -> println(response)
        }

}