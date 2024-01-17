package kr.co.lion.roompractice.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.lion.roompractice.R
import kr.co.lion.roompractice.databinding.ActivityRoomBinding
import kr.co.lion.roompractice.room.db.TextDatabase
import kr.co.lion.roompractice.room.db.TextEntity

class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = TextDatabase.getDatabase(this)

        with(binding){
            insert.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    val text = TextEntity(0, textInputArea.text.toString())
                    db.textDao().insert(text)
                    textInputArea.setText("")
                }
            }

            // 질문 1. List, Flow 둘의 차이
            // List를 사용했을 때
            CoroutineScope(Dispatchers.IO).launch {
                val text = db.textDao().getAllData().toString()
                Log.d("RoomTestLog", "List => $text")
                withContext(Dispatchers.Main){
                    resultArea.text = text
                }

            }

            getData.setOnClickListener {
                // Flow를 사용했을 때
                CoroutineScope(Dispatchers.IO).launch {
                    db.textDao().getAllDataAsFlow().collect{
                        val text = it.toString()

                        Log.d("RoomTestLog", "Flow => $text")
                        withContext(Dispatchers.Main){
                            resultArea2.text = text
                        }
                    }
                }
            }

            delete.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.textDao().deleteAllData()

                }
            }
        }
    }
}