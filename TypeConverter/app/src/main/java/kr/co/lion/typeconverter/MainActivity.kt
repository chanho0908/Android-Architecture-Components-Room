package kr.co.lion.typeconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.lion.automigration.db.TextDatabase
import kr.co.lion.automigration.db.TextEntity
import kr.co.lion.typeconverter.databinding.ActivityMainBinding
import java.util.Calendar

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
                        db.textDao().insert(TextEntity(0, text,
                            Calendar.getInstance().time))


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