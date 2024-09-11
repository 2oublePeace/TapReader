package com.emiryanvl.tapreader.domain.usecases;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class GetBookUseCase {

    BookRepository repository;

    @Inject
    public GetBookUseCase(BookRepository repository) {
        this.repository = repository;
    }

    public Observable<Book> execute(int id) {
        return repository.getBook(id);
    }
}
