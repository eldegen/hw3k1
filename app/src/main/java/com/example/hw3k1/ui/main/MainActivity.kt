package com.example.hw3k1.ui.main

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw3k1.base.BaseActivity
import com.example.hw3k1.databinding.ActivityMainBinding
import com.example.hw3k1.models.ImageModel
import com.example.hw3k1.ui.second.SecondActivity
import java.io.Serializable


class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var adapter: MainAdapter
    private var pictures = arrayListOf<ImageModel>()

    override fun initListeners() {
        nextButton()
    }

    override fun initView() {
        for (i in 1..6) {
            pictures.add(ImageModel("https://toppng.com/uploads/preview/sheep-png-images-11553734775mqnnvg1xw7.png"))
            pictures.add(ImageModel("https://www.citypng.com/public/uploads/preview/hd-sheep-lying-down-animal-png-31625257226bakp4axlct.png"))
            pictures.add(ImageModel("https://static.wikia.nocookie.net/minecraftstorymode/images/c/cc/Sheep.png/revision/latest?cb=20160802191801"))
        }

        adapter = MainAdapter(pictures)

        binding.recycler.adapter = adapter

        binding.recycler.layoutManager = GridLayoutManager(this, 3)

    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun otherThings() {

    }

    // My methods

    private fun nextButton() {
        binding.btnNext.setOnClickListener {
            var buffer: ArrayList<ImageModel> = ArrayList()
            buffer = adapter.getArrayList()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("array", buffer)
            startActivity(intent)
        }
    }

}