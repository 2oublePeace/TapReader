package com.emiryanvl.tapreader.domain.models

import androidx.compose.runtime.Immutable

@Immutable
data class Book(
    val id: Int = 0,
    val title: String,
    val author: String,
    val description: String,
    val imageUri: String? = null,
    val genre: String? = null,
    val isbn: String? = null
)
