package kr.co.lion.prctice_migration.db.dao

import androidx.room.*
import kr.co.lion.prctice_migration.db.entity.TextEntity
import kr.co.lion.prctice_migration.db.entity.TextEntity2

@Dao
interface TextDao2 {

    @Query("SELECT * FROM text_table2")
    fun getAllData() : List<TextEntity2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity2)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}