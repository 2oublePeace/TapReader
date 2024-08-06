package com.emiryanvl.tapreader.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.emiryanvl.tapreader.R;
import com.emiryanvl.tapreader.domain.model.Book;

import java.util.List;
import java.util.Random;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder> {

    private final List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.library_recycler_view_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookAdapter.ViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.titleTextView.setText(book.getTitle());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final int RGB_MAX_VALUE = 255;

        TextView titleTextView;
        CardView bookCardView;

        ViewHolder(View view) {
            super(view);
            bookCardView = view.findViewById(R.id.bookCardView);
            titleTextView = view.findViewById(R.id.titleTextView);

            Random random = new Random();
            //TODO: Реализовать альфа-канал
            bookCardView.setCardBackgroundColor(
                    Color.rgb(
                            random.nextInt(RGB_MAX_VALUE),
                            random.nextInt(RGB_MAX_VALUE),
                            random.nextInt(RGB_MAX_VALUE)
                    )
            );
        }
    }
}
