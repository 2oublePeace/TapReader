package com.emiryanvl.tapreader.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.databinding.FragmentLibraryBookItemBinding
import com.emiryanvl.tapreader.domain.models.Book
import kotlin.random.Random

class BookAdapter(
    var bookList: List<Book> = emptyList()
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

        private val bookImageView: ImageView = binding.bookImageView
        private val titleTextView: TextView = binding.titleTextView
        private val authorTextView: TextView = binding.authorTextView
        private val genreTextView: TextView = binding.genreTextView

        init {
            bookImageView.setBackgroundColor(
                Color.argb(
                    ALPHA_BACKGROUND_VALUE,
                    Random.nextInt(MAX_RGB_VALUE),
                    Random.nextInt(MAX_RGB_VALUE),
                    Random.nextInt(MAX_RGB_VALUE)
                )
            )
        }

        fun bind(bookItem: Book) {
            titleTextView.text = bookItem.title
            authorTextView.text = bookItem.author
            genreTextView.text = bookItem.genre
        }

        companion object {
            private const val ALPHA_BACKGROUND_VALUE = 64
            private const val MAX_RGB_VALUE = 255
        }
    }

    class Callback(
        private val newList: List<Book>, private val oldList: List<Book>
    ) : DiffUtil.Callback() {

        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldBook = oldList[oldItemPosition]
            val newBook = newList[newItemPosition]
            return oldBook.title == newBook.title
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldBook = oldList[oldItemPosition]
            val newBook = newList[newItemPosition]
            return oldBook == newBook
        }
    }
}
