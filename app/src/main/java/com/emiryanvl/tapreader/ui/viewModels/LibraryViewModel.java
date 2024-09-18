package com.emiryanvl.tapreader.ui.viewModels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.usecases.GetBooksBySubjectUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class LibraryViewModel extends ViewModel {

    private final GetBooksBySubjectUseCase getBooksBySubjectUseCase;
    public MutableLiveData<List<Book>> subjectBooks = new MutableLiveData<>();

    @Inject
    public LibraryViewModel(
        GetBooksBySubjectUseCase getBooksBySubjectUseCase
    ) {
        this.getBooksBySubjectUseCase = getBooksBySubjectUseCase;
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
