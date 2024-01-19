package kr.co.lion.prctice_migration.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.lion.prctice_migration.R
import kr.co.lion.prctice_migration.databinding.ActivityMainBinding
import kr.co.lion.prctice_migration.db.TextDatabase
import kr.co.lion.prctice_migration.db.entity.TextEntity
import kr.co.lion.prctice_migration.db.entity.TextEntity2

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val db = TextDatabase.getDatabase(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            insert.setOnClickListener(OnClickHandlingListener())
            getData.setOnClickListener(OnClickHandlingListener())
            delete.setOnClickListener(OnClickHandlingListener())
        }
    }

    inner class OnClickHandlingListener(): View.OnClickListener {
        override fun onClick(v: View?) {
            val text = binding.textInputArea.text.toString()
            when(v?.id){
                R.id.insert -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        db.textDao().insert(TextEntity(0, text))
                        db.textDao2().insert(TextEntity2(0, text))
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