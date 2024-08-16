package com.emiryanvl.tapreader.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.emiryanvl.tapreader.App;
import com.emiryanvl.tapreader.R;
import com.emiryanvl.tapreader.databinding.FragmentLibraryBinding;
import com.emiryanvl.tapreader.ui.adapters.BookAdapter;
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import javax.inject.Inject;

public class LibraryFragment extends Fragment {

    @Inject
    LibraryViewModel viewModel;
    private FragmentLibraryBinding binding;
    private NavController navController;

    public static LibraryFragment newInstance() {
        LibraryFragment fragment = new LibraryFragment();
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
        binding = FragmentLibraryBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        recyclerView();
        floatingActionButton();
    }

    private void recyclerView() {
        RecyclerView recommendedBooksRecyclerView = binding.recommendedBooksRecyclerView;
        RecyclerView newReleasesBooksRecyclerView = binding.newReleasesBooksRecyclerView;
        BookAdapter bookAdapter = new BookAdapter(viewModel.getAllBooks());
        recommendedBooksRecyclerView.setAdapter(bookAdapter);
        newReleasesBooksRecyclerView.setAdapter(bookAdapter);
    }

    private void floatingActionButton() {
        FloatingActionButton addBookfloatingActionButton = binding.addBookfloatingActionButton;
        addBookfloatingActionButton.setOnClickListener(
                button -> navController.navigate(R.id.action_libraryFragment_to_addBookFragment)
        );
    }
}