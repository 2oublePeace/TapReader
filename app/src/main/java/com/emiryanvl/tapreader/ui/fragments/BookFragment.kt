package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.emiryanvl.tapreader.databinding.FragmentBookBinding
import com.emiryanvl.tapreader.ui.viewModels.BookViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookFragment : Fragment() {

    private var _binding: FragmentBookBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<BookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        arguments?.let {
            val bookId = it.getInt(BOOK_ID_ARG_PARAM)
            viewModel.getBook(bookId)
        }
        _binding = FragmentBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        lifecycleScope.launch {
            viewModel.uiState.flowWithLifecycle(lifecycle, Lifecycle.State.STARTED).collect {
                with(binding) {
                    titleTextView.text = it.title
                    authorTextView.text = it.author
                    descriptionTextView.text = it.description
                }
            }
        }
        backArrowButton(navController)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun backArrowButton(navController: NavController) {
        val backArrowImageButton = binding.backArrowImageButton
        backArrowImageButton.setOnClickListener {
            navController.popBackStack()
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