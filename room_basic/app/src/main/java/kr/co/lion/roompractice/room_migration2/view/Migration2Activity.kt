package kr.co.lion.roompractice.room_migration2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.lion.roompractice.R
import kr.co.lion.roompractice.databinding.ActivityMigration2Binding
import kr.co.lion.roompractice.room_migration2.db.TextDatabase
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity
import kr.co.lion.roompractice.room_migration2.db.entity.TextEntity2

class Migration2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityMigration2Binding
    val db = TextDatabase.getDatabase(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMigration2Binding.inflate(layoutInflater)
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
                        db.textDao().insert(TextEntity(0, "db1 : $text"))
                        db.textDao2().insert(TextEntity2(1, "db2 : $text"))

                        binding.textInputArea.setText("")
                    }
                }

                R.id.getData -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        Log.d("MAIN", db.textDao().getAllData().toString())
                        Log.d("MAIN", db.textDao2().getAllData().toString())
                    }
                }

                R.id.delete -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.textDao().deleteAllData()
                        db.textDao2().deleteAllData()
                    }
                }
            }
        }

    }
}