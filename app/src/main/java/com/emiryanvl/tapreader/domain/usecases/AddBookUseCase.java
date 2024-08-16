package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Inject;

public class AddBookUseCase {

    BookRepository repository;

    @Inject
    public AddBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public void invoke(Book book) {
        repository.addBook(book);
    }
}
