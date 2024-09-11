package com.emiryanvl.tapreader.ui.viewModels;

import androidx.lifecycle.ViewModel;

import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.domain.usecases.AddBookUseCase;

import javax.inject.Inject;

public class AddBookViewModel extends ViewModel {

    AddBookUseCase addBookUseCase;

    @Inject
    public AddBookViewModel(AddBookUseCase addBookUseCase) {
        this.addBookUseCase = addBookUseCase;
    }

    public void addBook(Book book) {
        new Thread(() -> addBookUseCase.execute(book)).start();
    }
}
