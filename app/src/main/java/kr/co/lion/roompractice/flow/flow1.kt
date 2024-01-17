package kr.co.lion.roompractice.flow

// Flow를 사용하지 않은 예제
fun simple() : List<Int> = listOf()
fun main(){
    simple().forEach{
        println(it)
    }
}