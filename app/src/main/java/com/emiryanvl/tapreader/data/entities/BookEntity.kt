package com.emiryanvl.tapreader.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.emiryanvl.tapreader.domain.models.Book

@Entity(tableName = "book")
data class BookEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var title: String,
    var description: String,
) {
    fun toBookModel(): Book {
        return Book(
            title = this.title,
            description = this.description,
        )
    }
}