package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.usecases.GetQueryBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val getFilteredBooksUseCase: GetQueryBooksUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            getFilteredBooksUseCase("Михаил Елизаров").collect {
                _uiState.value = _uiState.value.copy(bookList = it)
            }
        }
    }

    data class UiState(
        val bookList: List<Book> = emptyList()
    )
}