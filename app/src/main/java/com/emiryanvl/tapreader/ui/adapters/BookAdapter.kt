package com.emiryanvl.tapreader.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.databinding.FragmentLibraryBookItemBinding
import com.emiryanvl.tapreader.domain.models.Book
import kotlin.random.Random

class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    var bookList: List<Book> = emptyList()

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

class BookDiffUtilCallback(
    private val newList: List<Book>,
    private val oldList: List<Book>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

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