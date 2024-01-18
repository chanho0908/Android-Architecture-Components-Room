package kr.co.lion.roompractice.room_advanced.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface NumberDao {
    // CRUD
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun create(numberEntity: NumberEntity)

    @Query("SELECT * FROM number_table")
    fun read() : Flow<List<NumberEntity>>

    @Update
    fun update(numberEntity: NumberEntity)

    @Delete
    fun delete(numberEntity: NumberEntity)
}