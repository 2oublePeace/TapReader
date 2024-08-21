package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.databinding.FragmentLibraryBinding
import com.emiryanvl.tapreader.ui.adapters.BookAdapter
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : BaseFragment<FragmentLibraryBinding>() {

    private val viewModel by viewModels<LibraryViewModel>()

    override fun getBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentLibraryBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        bookRecyclerView(navController)
    }

    private fun bookRecyclerView(navController: NavController) = with(binding) {
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