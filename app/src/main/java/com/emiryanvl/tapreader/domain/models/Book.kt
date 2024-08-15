package com.emiryanvl.tapreader.domain.models

data class Book(
    val id: Int = 0,
    val title: String,
    val description: String,
    val genre: String,
    val author: String
)
