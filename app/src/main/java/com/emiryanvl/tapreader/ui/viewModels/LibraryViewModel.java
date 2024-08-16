package com.emiryanvl.tapreader.ui.viewModels;

import androidx.lifecycle.ViewModel;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.usecases.GetAllBooksUseCase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.inject.Inject;

public class LibraryViewModel extends ViewModel {

    GetAllBooksUseCase getAllBooksUseCase;

    @Inject
    public LibraryViewModel(GetAllBooksUseCase getAllBooksUseCase) {
        this.getAllBooksUseCase = getAllBooksUseCase;
    }

    public List<Book> getAllBooks() {
        Callable<List<Book>> task = () -> getAllBooksUseCase.invoke();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<List<Book>> future = executor.submit(task);
        List<Book> bookList;

        try {
            bookList = future.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();

        return bookList;
    }
}
