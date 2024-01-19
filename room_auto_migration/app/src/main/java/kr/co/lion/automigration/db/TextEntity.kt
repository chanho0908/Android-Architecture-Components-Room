package kr.co.lion.automigration.db

import androidx.room.*

//@Entity(tableName = "text_table")
//data class TextEntity (
//
//    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "id")
//    val id : Int,
//    @ColumnInfo(name = "text")
//    val text : String
//
//)

@Entity(tableName = "text_table")
data class TextEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "text")
    val text : String,
    @ColumnInfo(name = "text2", defaultValue = "this is text2 default")
    val text2 : String,

    )