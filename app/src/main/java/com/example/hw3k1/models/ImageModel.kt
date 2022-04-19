package com.example.hw3k1.models

data class ImageModel(
    val url: String,
    var shadow: Boolean = false
) : java.io.Serializable