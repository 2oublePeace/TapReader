package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.databinding.FragmentLibraryBinding
import com.emiryanvl.tapreader.ui.adapters.BookAdapter
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : BaseFragment<FragmentLibraryBinding>() {

    private val viewModel by viewModels<LibraryViewModel>()
    override val inflate: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLibraryBinding =
        FragmentLibraryBinding::inflate

    override fun initializeViews() {
        bookRecyclerView()
    }

    private fun bookRecyclerView() = with(binding) {
        val navigateOnBookTap = { bundle: Bundle ->
            navController.navigate(
                R.id.action_libraryFragment_to_bookFragment,
                bundle
            )
        }

        val bookAdapter = BookAdapter(navigateOnBookTap)

        observeFlow(viewModel.uiState) {
            val bookDiffUtilCallback = BookAdapter.Callback(bookAdapter.bookList, it.bookList)
            val productDiffResult = DiffUtil.calculateDiff(bookDiffUtilCallback)
            bookAdapter.bookList = it.bookList
            productDiffResult.dispatchUpdatesTo(bookAdapter)
        }

        recommendedBooksRecyclerView.adapter = bookAdapter
        newReleasesBooksRecyclerView.adapter = bookAdapter
    }
}