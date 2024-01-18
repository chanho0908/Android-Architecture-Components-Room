package kr.co.lion.roompractice.room_migration.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.lion.roompractice.R
import kr.co.lion.roompractice.databinding.ActivityMigrationBinding
import kr.co.lion.roompractice.room_migration.db.TextDatabase
import kr.co.lion.roompractice.room_migration.db.TextEntity

class MigrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMigrationBinding
    val db = TextDatabase.getDatabase(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMigrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            insert.setOnClickListener(OnClickHandlingListener())
            getData.setOnClickListener(OnClickHandlingListener())
            delete.setOnClickListener(OnClickHandlingListener())
        }
    }

    inner class OnClickHandlingListener(): OnClickListener{
        override fun onClick(v: View?) {
            val text = binding.textInputArea.text.toString()
            when(v?.id){
                R.id.insert -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.textDao().insert(TextEntity(0, text))
                        binding.textInputArea.setText("")
                    }
                }

                R.id.getData -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        Log.d("MAIN", db.textDao().getAllData().toString())
                    }
                }

                R.id.delete -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.textDao().deleteAllData()
                    }
                }
            }
        }

    }
}