package kr.co.lion.roompractice.room_advanced.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_table")
data class NumberEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id : Int = 0,
    @ColumnInfo(name = "randomNumber")
    var randomNumber : String
)
