package kr.co.lion.automigration.db

import android.content.Context
import androidx.room.*
@Database(
    entities = [TextEntity::class],
    version = 1,
    autoMigrations = [
        AutoMigration(from = 2, to = 3)
    ]
)
abstract class TextDatabase : RoomDatabase(){

    abstract fun textDao() : TextDao

    companion object {

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