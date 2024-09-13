package com.emiryanvl.tapreader.data.local.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.emiryanvl.tapreader.domain.model.Book;

@Entity(tableName = "book")
public class BookEntity {

    public BookEntity(String title, String author, String description, String genre) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.genre = genre;
    }

    @PrimaryKey
    private int id;

    private String title;

    private String author;

    private String description;

    private String genre;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Book toBookModel() {
        return new Book(this.id, this.title, this.author, this.description, this.genre);
    }
}
