package com.example.hw3k1.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(link: String) {
    Glide.with(this).load(link).into(this)
}