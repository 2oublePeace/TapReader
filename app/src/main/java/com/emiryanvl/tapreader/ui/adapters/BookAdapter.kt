package com.emiryanvl.tapreader.ui.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.emiryanvl.tapreader.R
import com.emiryanvl.tapreader.domain.models.Book
import kotlin.random.Random

class BookAdapter(
    private val bookList: List<Book>
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.library_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = bookList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bookItem = bookList[position]
        holder.titleTextView.text = bookItem.title
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val maxRgbValue = 255
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        private val bookCardView: CardView = view.findViewById(R.id.bookCardView)

        init {
            bookCardView.setCardBackgroundColor(
                Color.rgb(
                    Random.nextInt(255),
                    Random.nextInt(255),
                    Random.nextInt(255)
                )
            )
        }
    }
}