package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Inject;

public class UpdateBookUseCase {

    BookRepository repository;

    @Inject
    public UpdateBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public void invoke(int id, Book book) {
        repository.updateBook(id, book);
    }
}
