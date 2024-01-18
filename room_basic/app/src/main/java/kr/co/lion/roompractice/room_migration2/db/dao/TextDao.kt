package kr.co.lion.roompractice.room_migration2.db.dao

import androidx.room.*
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity

@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}