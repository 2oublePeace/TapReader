package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.emiryanvl.tapreader.databinding.FragmentAddBookBinding
import com.emiryanvl.tapreader.ui.viewModels.AddBookViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddBookFragment : Fragment() {

    private var _binding: FragmentAddBookBinding? = null
    private val binding = _binding!!

    private val viewModel by viewModels<AddBookViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddBookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        initAddBookButton(navController)
    }

    private fun initAddBookButton(navController: NavController) {
        with(binding) {
            addBookButton.setOnClickListener {
                viewModel.addBook(
                    title = titleEditText.text.toString(),
                    description = descriptionEditText.text.toString()
                )
                navController.popBackStack()
            }
        }
    }
}