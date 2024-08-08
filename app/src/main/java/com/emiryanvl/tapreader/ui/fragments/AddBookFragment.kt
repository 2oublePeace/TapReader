package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.emiryanvl.tapreader.databinding.FragmentAddBookBinding
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.ui.viewModels.AddBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBookFragment : Fragment() {

    private var _binding: FragmentAddBookBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<AddBookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBookBinding.inflate(inflater, container, false)
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

        val addBookButton: Button = binding.addBookButton
        val titleEditText: TextView = binding.titleEditText
        val descriptionEditText: TextView = binding.descriptionEditText

        addBookButton.setOnClickListener {
            viewModel.addBook(
                Book(
                    title = titleEditText.text.toString(),
                    description = descriptionEditText.text.toString()
                )
            )
            navController.popBackStack()
        }
    }
}