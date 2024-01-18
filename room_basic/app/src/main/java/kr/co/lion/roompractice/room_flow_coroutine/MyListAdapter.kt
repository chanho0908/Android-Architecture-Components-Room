package kr.co.lion.roompractice.room_flow_coroutine

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.co.lion.roompractice.databinding.CatItemBinding
import kr.co.lion.roompractice.databinding.UserItemBinding
import kr.co.lion.roompractice.room_flow_coroutine.db.UserEntity

class MyListAdapter: ListAdapter<UserEntity, MyListAdapter.MyListAdapterViewHolder>(DiffCallback) {

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<UserEntity>(){
            override fun areItemsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
                return oldItem.id == newItem.id

            }

            override fun areContentsTheSame(oldItem: UserEntity, newItem: UserEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class MyListAdapterViewHolder(private val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userEntity: UserEntity){
            binding.name.text = userEntity.name
            binding.age.text = userEntity.age.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListAdapterViewHolder {
        return MyListAdapterViewHolder(UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyListAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}