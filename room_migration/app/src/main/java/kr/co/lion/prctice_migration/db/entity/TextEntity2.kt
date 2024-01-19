package kr.co.lion.prctice_migration.db.entity

import androidx.room.*

@Entity(tableName = "text_table2")
data class TextEntity2 (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    val id : Int,
    @ColumnInfo(name = "text2")
    val text2 : String

)