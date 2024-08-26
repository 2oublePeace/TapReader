package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiryanvl.tapreader.domain.usecases.GetBookUseCase
import com.emiryanvl.tapreader.domain.usecases.GetQueryBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getQueryBooksUseCase: GetQueryBooksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun getBook(isbn: String) = viewModelScope.launch {
        getQueryBooksUseCase("isbn:$isbn").collect {
            //TODO будет доделано в рамках другой задачи
            val book = it.firstOrNull() ?: throw Exception("")
            _uiState.value = _uiState.value.copy(
                title = book.title,
                description = book.description,
                author = book.author
            )
        }
    }

    data class UiState(
        val title: String = "",
        val author: String = "",
        val description: String = ""
    )
}