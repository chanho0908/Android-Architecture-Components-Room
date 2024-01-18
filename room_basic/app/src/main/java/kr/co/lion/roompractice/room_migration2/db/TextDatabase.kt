package kr.co.lion.roompractice.room_migration2.db

import android.content.Context
import androidx.room.*
import kr.co.lion.roompractice.room_migration2.db.dao.TextDao
import kr.co.lion.roompractice.room_migration2.db.dao.TextDao2
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity2

@Database( entities = [TextEntity::class, TextEntity2::class], version = 1)
abstract class TextDatabase : RoomDatabase(){
    abstract fun textDao() : TextDao
    abstract fun textDao2() : TextDao2

    companion object{
        @Volatile
        private var INSTANCE : TextDatabase? = null

        fun getDatabase(
            context: Context
        ) : TextDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TextDatabase::class.java,
                    "text_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }

    }
}