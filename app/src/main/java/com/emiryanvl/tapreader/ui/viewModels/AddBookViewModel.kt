package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.usecases.AddBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBookViewModel @Inject constructor(
    private val addBookUseCase: AddBookUseCase
) : ViewModel() {

    private val uiState = MutableStateFlow(UiState())

    fun bookTitleChanged(newText: String) {
        uiState.value = uiState.value.copy(title = newText)
    }

    fun authorTitleChanged(newText: String) {
        uiState.value = uiState.value.copy(author = newText)
    }

    fun descriptionTitleChanged(newText: String) {
        uiState.value = uiState.value.copy(description = newText)
    }

    fun genreTitleChanged(newText: String) {
        uiState.value = uiState.value.copy(genre = newText)
    }

    fun addBook() {
        viewModelScope.launch {
            addBookUseCase(
                Book(
                    title = uiState.value.title,
                    description = uiState.value.description,
                    genre = uiState.value.genre,
                    author = uiState.value.author
                )
            )
        }
    }

    data class UiState(
        val title: String = "",
        val description: String = "",
        val genre: String = "",
        val author: String = ""
    )
}