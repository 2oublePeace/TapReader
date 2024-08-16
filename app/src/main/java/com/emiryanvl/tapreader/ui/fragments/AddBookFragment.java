package com.emiryanvl.tapreader.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.emiryanvl.tapreader.App;
import com.emiryanvl.tapreader.databinding.FragmentAddBookBinding;
import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.ui.viewModels.AddBookViewModel;

import javax.inject.Inject;

public class AddBookFragment extends Fragment {

    @Inject
    AddBookViewModel viewModel;
    private FragmentAddBookBinding binding;
    private NavController navController;

    public static AddBookFragment newInstance() {
        AddBookFragment fragment = new AddBookFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.appComponent().inject(this);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentAddBookBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        addBookButton(navController);
    }

    private void addBookButton(NavController navController) {
        Button addBookButton = binding.addBookButton;
        addBookButton.setOnClickListener((button) -> {
            viewModel.addBook(new Book(
                    binding.titleEditText.getText().toString(),
                    binding.authorEditText.getText().toString(),
                    binding.descriptionEditText.getText().toString(),
                    binding.genreEditText.getText().toString()
            ));
            navController.popBackStack();
        });
    }
}