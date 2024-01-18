package kr.co.lion.roompractice.room_flow_coroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kr.co.lion.roompractice.R
import kr.co.lion.roompractice.databinding.ActivityRfcactivityBinding
import kr.co.lion.roompractice.room_flow_coroutine.db.MyDatabase
import kr.co.lion.roompractice.room_flow_coroutine.db.UserEntity

class RFCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRfcactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRfcactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db = MyDatabase.getDatabase(this)
        val myAdapter = MyListAdapter()

        binding.apply {
            userRV.apply {
                adapter = myAdapter
                layoutManager = LinearLayoutManager(this@RFCActivity)
            }

            save.setOnClickListener {
                val name = binding.name.text.toString()
                val age = binding.age.text.toString()

                val userEntity = UserEntity(0, name, age.toInt())
                db.userDao().insert(userEntity)
            }

            get.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.userDao().getAllDataAsFlow().collect{
                        withContext(Dispatchers.Main){
                            myAdapter.submitList(it)
                        }
                    }
                }
            }

            next.setOnClickListener {
                startActivity(Intent(this@RFCActivity, NextActivity::class.java))
            }
        }

    }
}