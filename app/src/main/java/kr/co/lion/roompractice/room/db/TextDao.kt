package kr.co.lion.roompractice.room.db

import androidx.room.*


@Dao
interface TextDao {

    @Query("SELECT * FROM text_table")
    fun getAllData() : List<TextEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(text : TextEntity)

    @Query("DELETE FROM text_table")
    fun deleteAllData()

}