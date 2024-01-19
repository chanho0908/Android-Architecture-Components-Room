package kr.co.lion.prctice_migration.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import kr.co.lion.prctice_migration.db.dao.TextDao
import kr.co.lion.prctice_migration.db.dao.TextDao2
import kr.co.lion.prctice_migration.db.entity.TextEntity
import kr.co.lion.prctice_migration.db.entity.TextEntity2

@Database( entities = [TextEntity::class, TextEntity2::class], version = 2)
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
                    //.fallbackToDestructiveMigration()
                    .addMigrations(MIGRATION_1_2)
                    .build()
                INSTANCE = instance
                instance
            }
        }

        val MIGRATION_1_2 = object : Migration(1,2){
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("CREATE TABLE `text_table2` " +
                        "(`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `text2` TEXT NOT NULL)")
            }

        }
    }
}