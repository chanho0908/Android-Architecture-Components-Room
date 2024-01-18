package kr.co.lion.roompractice.room_migration.db

import androidx.room.*

@Entity(tableName = "text_table")
data class TextEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "text")
    val text : String

)