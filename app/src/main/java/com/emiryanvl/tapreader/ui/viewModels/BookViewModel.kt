package com.emiryanvl.tapreader.ui.viewModels

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor() : ViewModel() {

    fun getText(): String {
        return ""
    }
}
