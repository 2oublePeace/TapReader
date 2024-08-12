package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.databinding.FragmentLibraryBinding
import com.emiryanvl.tapreader.ui.adapters.BookAdapter
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding = _binding!!

    private val viewModel by viewModels<LibraryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        initBookRecyclerView()
        initAddBookFloatingActionButton(navController)
    }

    private fun initBookRecyclerView() {
        val bookAdapter = BookAdapter()
        val layoutManager = GridLayoutManager(this.context, RECYCLER_VIEW_SPAN_COUNT)

        lifecycleScope.launch {
            viewModel.bookList
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect {
                    val bookDiffUtilCallback = BookAdapter.Callback(bookAdapter.bookList, it)
                    val productDiffResult = DiffUtil.calculateDiff(bookDiffUtilCallback)
                    bookAdapter.bookList = it
                    productDiffResult.dispatchUpdatesTo(bookAdapter)
                }
        }

        with(binding) {
            bookRecyclerView.adapter = bookAdapter
            bookRecyclerView.layoutManager = layoutManager
        }
    }

    private fun initAddBookFloatingActionButton(navController: NavController) {
        binding.addBookfloatingActionButton.setOnClickListener {
            navController.navigate(R.id.action_libraryFragment_to_addBookFragment)
        }
    }

    companion object {
        private const val RECYCLER_VIEW_SPAN_COUNT = 2
    }
}