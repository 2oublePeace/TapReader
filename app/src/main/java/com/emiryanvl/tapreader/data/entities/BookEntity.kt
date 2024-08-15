package com.emiryanvl.tapreader.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emiryanvl.tapreader.domain.models.Book

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val genre: String,
    val author: String
) {
    fun toBookModel() = Book(
        id = this.id,
        title = this.title,
        description = this.description,
        genre = this.genre,
        author = this.author
    )
}