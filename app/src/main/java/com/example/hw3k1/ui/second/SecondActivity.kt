package com.example.hw3k1.ui.second

import android.util.Log
import android.view.LayoutInflater
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw3k1.base.BaseActivity
import com.example.hw3k1.databinding.ActivitySecondBinding
import com.example.hw3k1.models.ImageModel
import com.example.hw3k1.ui.main.MainAdapter

class SecondActivity : BaseActivity<ActivitySecondBinding>() {

    private lateinit var adapter: MainAdapter
    private var pictures = arrayListOf<ImageModel>()

    override fun inflateVB(inflater: LayoutInflater): ActivitySecondBinding {
        return ActivitySecondBinding.inflate(inflater)
    }

    override fun initListeners() {

    }

    override fun initView() {
        pictures = intent.extras?.get("array") as ArrayList<ImageModel>

        adapter = MainAdapter(pictures)

        binding.recycler.adapter = adapter

        binding.recycler.layoutManager = GridLayoutManager(this, 3)

    }

    override fun otherThings() {

    }

}