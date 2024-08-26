package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import com.emiryanvl.tapreader.databinding.FragmentBookBinding
import com.emiryanvl.tapreader.ui.viewModels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookFragment : BaseFragment<FragmentBookBinding>() {

    private val viewModel by viewModels<BookViewModel>()
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBookBinding =
        FragmentBookBinding::inflate

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val bookIsbn = it.getString(BOOK_ISBN_ARG_PARAM)
            bookIsbn?.let { isbn -> viewModel.getBook(isbn) }
        }
    }

    override fun initializeViews() {
        setBookData()
        backArrowButton(navController)
    }

    private fun backArrowButton(navController: NavController) = with(binding) {
        backArrowImageButton.setOnClickListener {
            navController.popBackStack()
        }
    }

    private fun setBookData() = with(binding) {
        observeFlow(viewModel.uiState) {
            titleTextView.text = it.title
            authorTextView.text = it.author
            descriptionTextView.text = it.description
        }
    }

    companion object {
        private const val BOOK_ISBN_ARG_PARAM = "bookIsbn"

        @JvmStatic
        fun newInstance(bookId: Int) = BookFragment().apply {
            arguments = Bundle().apply {
                putInt(BOOK_ISBN_ARG_PARAM, bookId)
            }
        }
    }
}