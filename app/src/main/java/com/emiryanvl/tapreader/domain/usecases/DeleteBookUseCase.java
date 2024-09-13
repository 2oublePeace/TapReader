package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Inject;

public class DeleteBookUseCase {

    private final BookRepository repository;

    @Inject
    public DeleteBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public void execute(int id) {
        repository.deleteBook(id);
    }
}
