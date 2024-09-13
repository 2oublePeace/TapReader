package com.emiryanvl.tapreader.ui.fragments;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.emiryanvl.tapreader.App;
import com.emiryanvl.tapreader.R;
import com.emiryanvl.tapreader.databinding.FragmentLibraryBinding;
import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.ui.adapters.BookAdapter;
import com.emiryanvl.tapreader.ui.viewModels.LibraryViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import javax.inject.Inject;

public class LibraryFragment extends BaseFragment<FragmentLibraryBinding> {

    @Inject
    LibraryViewModel viewModel;

    @Override
    protected Inflater<FragmentLibraryBinding> getInflater() {
        return FragmentLibraryBinding::inflate;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.appComponent().inject(this);
    }

    @Override
    protected void initializeViews() {
        viewModel.getBooksBySubject();
        recyclerView();
        floatingActionButton();
    }

    private void recyclerView() {
        RecyclerView recommendedBooksRecyclerView = binding.recommendedBooksRecyclerView;
        RecyclerView newReleasesBooksRecyclerView = binding.newReleasesBooksRecyclerView;

        viewModel.subjectBooks.observe(getViewLifecycleOwner(), bookList -> {
            BookAdapter bookAdapter = new BookAdapter(bookList);
            recommendedBooksRecyclerView.setAdapter(bookAdapter);
            newReleasesBooksRecyclerView.setAdapter(bookAdapter);
        });
    }

    private void floatingActionButton() {
        FloatingActionButton addBookfloatingActionButton = binding.addBookfloatingActionButton;
        addBookfloatingActionButton.setOnClickListener(
            button -> navController.navigate(R.id.action_libraryFragment_to_addBookFragment)
        );
    }

    public static LibraryFragment newInstance() {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }
}