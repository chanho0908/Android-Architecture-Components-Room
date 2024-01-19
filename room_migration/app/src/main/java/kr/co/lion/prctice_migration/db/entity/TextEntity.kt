package kr.co.lion.prctice_migration.db.entity

import androidx.room.*

@Entity(tableName = "text_table")
data class TextEntity (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "text")
    val text : String

)