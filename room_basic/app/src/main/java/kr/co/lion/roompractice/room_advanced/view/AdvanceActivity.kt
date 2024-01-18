package kr.co.lion.roompractice.room_advanced.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import kr.co.lion.roompractice.R
import kr.co.lion.roompractice.databinding.ActivityAdvanceBinding
import kr.co.lion.roompractice.room_advanced.db.NumberEntity
import kr.co.lion.roompractice.room_advanced.viewModel.MainViewModel

class AdvanceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAdvanceBinding
    private val viewModel: MainViewModel by viewModels()
    private lateinit var numberArrayList: ArrayList<NumberEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAdvanceBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            button.setOnClickListener {
                val ranNumber = (0..100).random().toString()
                val numberEntity = NumberEntity(0, ranNumber)
                viewModel.create(numberEntity)
            }


            viewModel.read()
            viewModel.numberEntityList.observe(this@AdvanceActivity){
                numberArrayList = it as ArrayList<NumberEntity>

                val adapter = CustomAdapter(numberArrayList)
                rv.adapter = adapter
                rv.layoutManager = LinearLayoutManager(this@AdvanceActivity)

                onClickEventHandling(adapter)
            }
        }

    }

    private fun onClickEventHandling(adapter: CustomAdapter){
        adapter.updateClick = object : CustomAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                viewModel.update(numberArrayList[position])
            }

        }

        adapter.deleteClick = object : CustomAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                viewModel.delete(numberArrayList[position])
            }

        }

    }
}