package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.domain.usecases.GetAllBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LibraryViewModel @Inject constructor(
    private val getAllBooksUseCase: GetAllBooksUseCase
) : ViewModel() {

    private val _bookList = MutableStateFlow<List<Book>>(emptyList())
    val bookList = _bookList.asStateFlow()

    init {
        viewModelScope.launch {
            getAllBooksUseCase().collect {
                _bookList.value = it
            }
        }
    }
}