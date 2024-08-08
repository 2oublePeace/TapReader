package com.emiryanvl.tapreader.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.databinding.FragmentLibraryBookItemBinding
import com.emiryanvl.tapreader.domain.models.Book
import kotlin.random.Random

class BookAdapter(
    private val bookList: List<Book>
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = FragmentLibraryBookItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookItem = bookList[position]
        holder.bind(bookItem)
    }

    class ViewHolder(
        binding: FragmentLibraryBookItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private val bookCardView: CardView = binding.bookCardView
        private val titleTextView: TextView = binding.titleTextView

        fun bind(bookItem: Book) {
            titleTextView.text = bookItem.title

            bookCardView.setCardBackgroundColor(
                Color.rgb(
                    Random.nextInt(MAX_RGB_VALUE),
                    Random.nextInt(MAX_RGB_VALUE),
                    Random.nextInt(MAX_RGB_VALUE)
                )
            )
        }

        companion object {
            private const val MAX_RGB_VALUE = 255
        }
    }
}