package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.emiryanvl.tapreader.databinding.FragmentBookBinding
import com.emiryanvl.tapreader.ui.viewModels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookFragment : BaseFragment<FragmentBookBinding>() {

    private val viewModel by viewModels<BookViewModel>()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentBookBinding.inflate(inflater, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val bookId = it.getInt(BOOK_ID_ARG_PARAM)
            viewModel.getBook(bookId)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
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
        private const val BOOK_ID_ARG_PARAM = "bookId"

        @JvmStatic
        fun newInstance(bookId: Int) = BookFragment().apply {
            arguments = Bundle().apply {
                putInt(BOOK_ID_ARG_PARAM, bookId)
            }
        }
    }
}