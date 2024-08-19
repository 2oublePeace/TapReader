package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiryanvl.tapreader.domain.usecases.GetBookUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState = _uiState.asStateFlow()

    fun getBook(id: Int) = viewModelScope.launch {
        val book = getBookUseCase(id)
        _uiState.value = _uiState.value.copy(
            title = book.title,
            description = book.description,
            author = book.author
        )
    }

    data class UiState(
        val title: String = "",
        val author: String = "",
        val description: String = ""
    )
}