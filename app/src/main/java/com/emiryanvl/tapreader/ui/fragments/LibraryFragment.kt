package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.databinding.FragmentLibraryBinding
import com.emiryanvl.tapreader.ui.adapters.BookAdapter
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LibraryFragment : Fragment() {

    private var _binding: FragmentLibraryBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<LibraryViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLibraryBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        val bookList = viewModel.bookList.value
        val layoutManager = GridLayoutManager(this.context, RECYCLER_VIEW_SPAN_COUNT)
        val bookAdapter = BookAdapter(bookList)
        val bookRecyclerView: RecyclerView = binding.bookRecyclerView

        bookRecyclerView.layoutManager = layoutManager
        bookRecyclerView.adapter = bookAdapter

        val floatingActionButton: FloatingActionButton = binding.addBookfloatingActionButton
        floatingActionButton.setOnClickListener {
            navController.navigate(
                R.id.action_libraryFragment_to_addBookFragment
            )
        }
    }

    companion object {
        private const val RECYCLER_VIEW_SPAN_COUNT = 2
    }
}