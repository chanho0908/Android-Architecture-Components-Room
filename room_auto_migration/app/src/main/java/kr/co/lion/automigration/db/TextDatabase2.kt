package kr.co.lion.automigration.db

import android.content.Context
import androidx.room.*
import androidx.room.migration.AutoMigrationSpec

@Database(
    entities = [TextEntity::class],
    version = 1,
    autoMigrations = [
        AutoMigration(from = 2, to = 3,
            spec = TextDatabase2.deleteOldTable::class,
        )

    ]
)
abstract class TextDatabase2 : RoomDatabase(){
    abstract fun textDao() : TextDao
    @DeleteTable(tableName = "text_table")
    class deleteOldTable

    @RenameTable(fromTableName = "text_table", toTableName = "new_text_table")
    class renameTable

    @DeleteColumn(tableName = "text_table", columnName = "text")
    class deleteOldColumn

    @RenameColumn(tableName = "text_table", fromColumnName = "text2", toColumnName = "newText")
    class renameOldColumn

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
                    ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
