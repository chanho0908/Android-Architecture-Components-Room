package kr.co.lion.roompractice.diffUtil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.lion.roompractice.databinding.CatItemBinding

class CatListAdapter: ListAdapter<CatDataModel, CatListAdapter.CatViewHolder>(DiffCallback){

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<CatDataModel>(){
            override fun areItemsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 고유값 비교

                return oldItem.catId == newItem.catId
            }

            override fun areContentsTheSame(oldItem: CatDataModel, newItem: CatDataModel): Boolean {
                // 내용
                return oldItem == newItem
            }
        }
    }
    inner class CatViewHolder(val binding: CatItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val binding = CatItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CatViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val binding = holder.binding
        binding.catId.text = getItem(position).catId.toString()
        binding.catName.text = getItem(position).catName
        binding.catAge.text = getItem(position).catAge.toString()
    }


}