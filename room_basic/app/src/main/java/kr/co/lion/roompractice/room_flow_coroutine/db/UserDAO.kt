package kr.co.lion.roompractice.room_flow_coroutine.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDAO {

    @Query("SELECT * FROM user_table")
    fun getAllData() : List<UserEntity>

    @Query("SELECT * FROM user_table")
    fun getAllDataAsFlow() : Flow<List<UserEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(user : UserEntity)

    @Update
    fun update(userEntity: UserEntity)

    @Delete
    fun delete(userEntity: UserEntity)


}