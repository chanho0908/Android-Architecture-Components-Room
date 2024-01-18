package kr.co.lion.roompractice.room_migration2.db.dao

import androidx.room.*
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity2

@Dao
interface TextDao2 {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity2>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text: TextEntity2)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}