package kr.co.lion.roompractice.room_advanced.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.co.lion.roompractice.databinding.NumberItemBinding
import kr.co.lion.roompractice.room_advanced.db.NumberEntity

class CustomAdapter(private val dataSet: ArrayList<NumberEntity>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {

    interface ItemClick{
        fun onClick(view: View, position: Int)
    }

    var updateClick: ItemClick ?=null
    var deleteClick: ItemClick ?=null

    inner class MyViewHolder(val binding: NumberItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(NumberItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = dataSet.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val binding = holder.binding
        binding.apply {
            id.text = dataSet[position].id.toString()
            randomNum.text = dataSet[position].randomNumber

            update.setOnClickListener {v->
                updateClick?.onClick(v, position)
            }

            delete.setOnClickListener {v->
                deleteClick?.onClick(v, position)
            }
        }

    }

}