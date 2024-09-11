package com.emiryanvl.tapreader.data.repositories;

import com.emiryanvl.tapreader.data.dao.BookDao;
import com.emiryanvl.tapreader.data.entities.BookEntity;
import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;

public class BookRepositoryImpl implements BookRepository {

    BookDao bookDao;

    @Inject
    public BookRepositoryImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Observable<List<Book>> getAllBooks() {
        return bookDao.findAll()
            .map(bookEntities -> {
                return bookEntities.stream()
                    .map(BookEntity::toBookModel)
                    .collect(Collectors.toList());
            });
    }

    @Override
    public Observable<Book> getBook(int id) {
        return bookDao.findById(id).map(bookEntity -> bookEntity.toBookModel());
    }

    @Override
    public Completable addBook(Book book) {
        return bookDao.insert(
            new BookEntity(
                book.getTitle(),
                book.getAuthor(),
                book.getDescription(),
                book.getGenre()
            )
        );
    }

    @Override
    public void updateBook(int id, Book book) {
        BookEntity bookEntity = bookDao.findById(id).blockingFirst();
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());
        bookEntity.setDescription(book.getDescription());
        bookEntity.setGenre(book.getGenre());
    }

    @Override
    public void deleteBook(int id) {
        BookEntity book = bookDao.findById(id).blockingFirst();
        bookDao.delete(book);
    }
}
