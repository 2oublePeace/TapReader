package com.emiryanvl.tapreader.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.emiryanvl.tapreader.R;
import com.emiryanvl.tapreader.domain.model.Book;
import com.emiryanvl.tapreader.ui.adapters.BookAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class LibraryFragment extends Fragment {

    private NavController navController;

    public LibraryFragment() {
    }

    public static LibraryFragment newInstance() {
        LibraryFragment fragment = new LibraryFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("Муму", "Муму"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));
        bookList.add(new Book("sdfsdf", "sdfsdfsdf"));

        GridLayoutManager manager = new GridLayoutManager(this.getContext(), 2);
        BookAdapter bookAdapter = new BookAdapter(bookList);

        RecyclerView bookRecyclerView = view.findViewById(R.id.bookRecyclerView);

        bookRecyclerView.setLayoutManager(manager);
        bookRecyclerView.setAdapter(bookAdapter);

        FloatingActionButton fab = view.findViewById(R.id.addBookfloatingActionButton);
        fab.setOnClickListener(
            fabView -> navController.navigate(R.id.action_libraryFragment_to_addBookFragment)
        );
    }
}