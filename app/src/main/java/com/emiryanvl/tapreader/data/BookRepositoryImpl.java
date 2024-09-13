package com.emiryanvl.tapreader.data;

import com.emiryanvl.tapreader.data.local.dao.BookDao;
import com.emiryanvl.tapreader.data.local.entities.BookEntity;
import com.emiryanvl.tapreader.data.remote.dataSources.RemoteBookDataSource;
import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

public class BookRepositoryImpl implements BookRepository {

    private final BookDao bookDao;
    private final RemoteBookDataSource remoteBookDataSource;

    @Inject
    public BookRepositoryImpl(BookDao bookDao, RemoteBookDataSource remoteBookDataSource) {
        this.bookDao = bookDao;
        this.remoteBookDataSource = remoteBookDataSource;
    }

    @Override
    public Observable<List<Book>> getAllBooks() {
        return bookDao.findAll()
            .map(bookEntities -> bookEntities.stream()
                .map(BookEntity::toBookModel)
                .collect(Collectors.toList()));
    }

    @Override
    public Observable<List<Book>> getBooksByQuery(String query) {
        return remoteBookDataSource.getBooksByQuery(query);
    }

    @Override
    public Observable<List<Book>> getBooksBySubject(String subject) {
        return remoteBookDataSource.getBooksBySubject(subject);
    }

    @Override
    public Observable<Book> getBook(int id) {
        return bookDao.findById(id).map(BookEntity::toBookModel);
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
