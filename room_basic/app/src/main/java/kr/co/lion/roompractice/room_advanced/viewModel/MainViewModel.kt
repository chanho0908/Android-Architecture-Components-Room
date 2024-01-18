package kr.co.lion.roompractice.room_advanced.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kr.co.lion.roompractice.room_advanced.db.NumberEntity
import kr.co.lion.roompractice.room_advanced.repository.Repository

class MainViewModel : ViewModel() {

    private val repository = Repository()

    lateinit var numberEntityList: LiveData<List<NumberEntity>>

    fun create(numberEntity: NumberEntity) = viewModelScope.launch(Dispatchers.IO){
        repository.create(numberEntity)
    }

    fun read(){
        numberEntityList = repository.read().asLiveData()
    }

    fun update(numberEntity: NumberEntity) = viewModelScope.launch (Dispatchers.IO) {
        val ranNumber = (0..100).random().toString()
        numberEntity.randomNumber = "update : $ranNumber"

        repository.update(numberEntity)
    }

    fun delete(numberEntity: NumberEntity) = viewModelScope.launch (Dispatchers.IO) {
        repository.delete(numberEntity)
    }


}