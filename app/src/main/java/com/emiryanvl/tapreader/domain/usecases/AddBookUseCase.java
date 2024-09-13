package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;

public class AddBookUseCase {

    private final BookRepository repository;

    @Inject
    public AddBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public Completable execute(Book book) {
        return repository.addBook(book);
    }
}
