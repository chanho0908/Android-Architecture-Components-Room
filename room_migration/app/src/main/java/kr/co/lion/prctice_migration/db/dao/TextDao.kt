package kr.co.lion.prctice_migration.db.dao

import androidx.room.*
import kr.co.lion.prctice_migration.db.entity.TextEntity

@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}