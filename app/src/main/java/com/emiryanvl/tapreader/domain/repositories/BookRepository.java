package com.emiryanvl.tapreader.domain.repositories;

import com.emiryanvl.tapreader.domain.model.Book;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public interface BookRepository {
    Observable<List<Book>> getAllBooks();

    Observable<Book> getBook(int id);

    Completable addBook(Book book);

    void updateBook(int id, Book book);

    void deleteBook(int id);
}
