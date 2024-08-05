package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.usecases.AddBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBookViewModel @Inject constructor(
    private val addBookUseCase: AddBookUseCase
) : ViewModel() {

    fun addBook(title: String, description: String) {
        viewModelScope.launch {
            addBookUseCase(Book(title, description))
        }
    }
}