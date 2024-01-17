package kr.co.lion.roompractice.diffUtil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kr.co.lion.roompractice.databinding.ActivityMainBinding

// DiffUTil / ListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CatListAdapter()

        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(this)

        adapter.submitList(firstSetUpData())

        lifecycleScope.launch(Dispatchers.IO)  {
            Log.d("sadasdasd", "sdasd")
            delay(3000)
            adapter.submitList(seCondSetUpData())
        }
    }

    fun firstSetUpData() : ArrayList<CatDataModel>{
        val cat1 = CatDataModel(1, "cat1", 10)
        val cat2 = CatDataModel(2, "cat2", 11)
        val cat3 = CatDataModel(3, "cat3", 12)
        val cat4 = CatDataModel(4, "cat4", 13)
        val cat5 = CatDataModel(5, "cat5", 14)


        val arr = ArrayList<CatDataModel>()

        arr.add(cat1)
        arr.add(cat2)
        arr.add(cat3)
        arr.add(cat4)
        arr.add(cat5)

        return arr
    }

    fun seCondSetUpData() : ArrayList<CatDataModel>{
        val cat3 = CatDataModel(3, "cat3", 13)
        val cat4 = CatDataModel(4, "cat4", 14)
        val cat5 = CatDataModel(5, "cat5", 15)
        val cat6 = CatDataModel(6, "cat6", 16)
        val cat7 = CatDataModel(7, "cat7", 16)
        val cat8 = CatDataModel(8, "cat8", 17)

        val arr = ArrayList<CatDataModel>()

        arr.add(cat3)
        arr.add(cat4)
        arr.add(cat5)
        arr.add(cat6)
        arr.add(cat7)
        arr.add(cat8)

        return arr
    }
}