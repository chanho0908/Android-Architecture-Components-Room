package kr.co.lion.roompractice.room_advanced

import android.app.Application
import android.content.Context
import android.util.Log

class MyApp : Application(){

    init {
        instance = this
    }

    companion object {

        private var instance : MyApp? = null

        fun context() : Context {
            return instance!!.applicationContext
        }

    }
}

fun main(){
    Log.d("sdasdsa", MyApp.context().toString())
}