package com.emiryanvl.tapreader.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.domain.models.Book
import com.emiryanvl.tapreader.ui.adapters.BookAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton


class LibraryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        val bookList: MutableList<Book> = mutableListOf()
        bookList.add(Book("Муму", "Муму"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))
        bookList.add(Book("sdfsdf", "sdfsdfsdf"))

        val manager = GridLayoutManager(this.context, 2)
        val bookAdapter = BookAdapter(bookList)

        val bookRecyclerView: RecyclerView = view.findViewById(R.id.bookRecyclerView)

        bookRecyclerView.layoutManager = manager
        bookRecyclerView.adapter = bookAdapter

        val fab: FloatingActionButton = view.findViewById(R.id.addBookfloatingActionButton)
        fab.setOnClickListener {
            navController.navigate(
                R.id.action_libraryFragment_to_addBookFragment
            )
        }
    }
}