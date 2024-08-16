package com.emiryanvl.tapreader.domain.repositories;

import com.emiryanvl.tapreader.domain.model.Book;

import java.util.List;

public interface BookRepository {
    List<Book> getAllBooks();

    Book getBook(int id);

    void addBook(Book book);

    void updateBook(int id, Book book);

    void deleteBook(int id);
}
