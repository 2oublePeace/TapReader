package com.emiryanvl.tapreader.ui.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.usecases.GetAllBooksUseCase;
import com.emiryanvl.tapreader.domain.usecases.GetBookUseCase;
import com.emiryanvl.tapreader.domain.usecases.GetBooksBySubjectUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LibraryViewModel extends ViewModel {

    private final GetAllBooksUseCase getAllBooksUseCase;
    private final GetBookUseCase getBookUseCase;
    private final GetBooksBySubjectUseCase getBooksBySubjectUseCase;
    public MutableLiveData<List<Book>> bookList = new MutableLiveData<>();
    public MutableLiveData<Book> book = new MutableLiveData<>();
    public MutableLiveData<List<Book>> subjectBooks = new MutableLiveData<>();

    @Inject
    public LibraryViewModel(
        GetAllBooksUseCase getAllBooksUseCase,
        GetBookUseCase getBookUseCase,
        GetBooksBySubjectUseCase getBooksBySubjectUseCase
    ) {
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.getBookUseCase = getBookUseCase;
        this.getBooksBySubjectUseCase = getBooksBySubjectUseCase;
    }

    public void getAllBooks() {
        Disposable disposable = getAllBooksUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(list -> {
                bookList.setValue(list);
            });
    }

    public void getBook() {
        Disposable disposable = getBookUseCase.execute(1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(bookItem -> {
                book.setValue(bookItem);
            });
    }

    public void getBooksBySubject() {
        Disposable disposable = getBooksBySubjectUseCase.execute("fiction")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(sb -> {
                subjectBooks.setValue(sb);
            });
    }
}
