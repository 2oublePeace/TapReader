package com.emiryanvl.tapreader.ui.viewModels;

import android.annotation.SuppressLint;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.usecases.AddBookUseCase;
import com.emiryanvl.tapreader.domain.usecases.GetAllBooksUseCase;
import com.emiryanvl.tapreader.domain.usecases.GetBookUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LibraryViewModel extends ViewModel {

    private GetAllBooksUseCase getAllBooksUseCase;
    private GetBookUseCase getBookUseCase;
    private AddBookUseCase addBookUseCase;
    public MutableLiveData<List<Book>> bookList = new MutableLiveData<>();
    public MutableLiveData<Book> book = new MutableLiveData<>();

    @Inject
    public LibraryViewModel(
        GetAllBooksUseCase getAllBooksUseCase,
        GetBookUseCase getBookUseCase,
        AddBookUseCase addBookUseCase
    ) {
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.getBookUseCase = getBookUseCase;
        this.addBookUseCase = addBookUseCase;
    }

    public void addBook() {
        addBookUseCase.execute(new Book(
                "asdasd",
                "asdsad",
                "asdasd",
                "asdasd"
            ))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribe();
    }

    @SuppressLint("CheckResult")
    public void getAllBooks() {
        getAllBooksUseCase.execute()
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(list -> {
                bookList.setValue(list);
            });
    }

    public void getBook() {
        getBookUseCase.execute(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(bookItem -> {
                book.setValue(bookItem);
            });
    }
}
