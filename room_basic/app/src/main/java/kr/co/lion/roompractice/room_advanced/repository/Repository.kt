package kr.co.lion.roompractice.room_advanced.repository

import kr.co.lion.roompractice.room_advanced.MyApp
import kr.co.lion.roompractice.room_advanced.db.MyDatabase
import kr.co.lion.roompractice.room_advanced.db.NumberEntity

class Repository {

    // CRUD
    private val context = MyApp.context()

    private val db = MyDatabase.getDatabase(context)

    fun create(numberEntity: NumberEntity) = db.numberDao().create(numberEntity)

    fun read() = db.numberDao().read()

    fun update(numberEntity: NumberEntity) = db.numberDao().update(numberEntity)

    fun delete(numberEntity: NumberEntity) = db.numberDao().delete(numberEntity)

}