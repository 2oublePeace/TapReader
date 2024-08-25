package com.emiryanvl.tapreader.domain.models

data class Book(
    val id: Int = 0,
    val title: String,
    val description: String,
    val genre: String? = null,
    val author: String,
    val isbn: String,
    val imageUri: String? = null
)
