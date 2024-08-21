package com.emiryanvl.tapreader.ui.adapters

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.databinding.FragmentLibraryBookItemBinding
import com.emiryanvl.tapreader.domain.models.Book
import kotlin.random.Random

class BookAdapter(
    private val navigateOnBookTap: (Bundle) -> Unit = {},
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
        holder.itemView.setOnClickListener {
            val bundle = bundleOf(BOOK_ISBN_ARG_PARAM to bookItem.isbn)
            navigateOnBookTap(bundle)
        }
    }

    companion object {
        private const val BOOK_ISBN_ARG_PARAM = "bookIsbn"
    }

    class ViewHolder(
        private val binding: FragmentLibraryBookItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(bookItem: Book) = with(binding) {
            titleTextView.text = bookItem.title
            authorTextView.text = bookItem.author
            bookItem.genre?.let {
                genreTextView.isVisible = true
                genreTextView.text = translateGenre(binding.root.context, bookItem.genre)
            } ?: let { genreTextView.isVisible = false }

            bookImageView.setBackgroundColor(
                Color.argb(
                    ALPHA_BACKGROUND_VALUE,
                    Random.nextInt(MAX_RGB_VALUE),
                    Random.nextInt(MAX_RGB_VALUE),
                    Random.nextInt(MAX_RGB_VALUE)
                )
            )
        }

        private fun translateGenre(context: Context, englishGenre: String): String {
            return when (englishGenre) {
                "Fiction" -> context.getString(R.string.genre_fiction)
                "Science Fiction" -> context.getString(R.string.genre_science_fiction)
                "Fantasy" -> context.getString(R.string.genre_fantasy)
                "Mystery" -> context.getString(R.string.genre_mystery)
                "Biography" -> context.getString(R.string.genre_biography)
                else -> englishGenre
            }
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
            return oldBook.id == newBook.id
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldBook = oldList[oldItemPosition]
            val newBook = newList[newItemPosition]
            return oldBook == newBook
        }
    }
}
