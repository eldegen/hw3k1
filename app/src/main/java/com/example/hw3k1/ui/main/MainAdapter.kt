package com.example.hw3k1.ui.main

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw3k1.databinding.ItemPhotoBinding
import com.example.hw3k1.extensions.load
import com.example.hw3k1.models.ImageModel

class MainAdapter(private var pictures: ArrayList<ImageModel>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private var bufferPics = arrayListOf<ImageModel>()

    class ViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            binding.imageView.load(pictures[position].url)

            binding.checkBox.setOnClickListener {
                if (!pictures[position].shadow) {
                    pictures[position].shadow = true
                    binding.viewSelected.visibility = View.VISIBLE
                    Log.d("bruh", "onBindViewHolder: $position")
                } else {
                    pictures[position].shadow = false
                    binding.viewSelected.visibility = View.GONE
                    Log.d("bruh", "onBindViewHolder: $position")
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return pictures.size
    }

    // My methods

    fun getArrayList() : ArrayList<ImageModel> {
        bufferPics.clear()

        for (i in 0 until pictures.size) {
            if (pictures[i].shadow) {
                bufferPics.add(pictures[i])
            }
        }
        Log.d("bruh", "getArrayList: $bufferPics")
        return bufferPics
    }

}