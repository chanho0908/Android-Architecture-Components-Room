package kr.co.lion.roompractice.room_migration2.db.entity

import androidx.room.*

@Entity(tableName = "text_table2")
data class TextEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "text")
    val text : String

)