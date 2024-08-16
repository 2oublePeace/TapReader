package com.emiryanvl.tapreader.ui.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.emiryanvl.tapreader.databinding.FragmentLibraryBookItemBinding;
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FragmentLibraryBookItemBinding binding = FragmentLibraryBookItemBinding.inflate(inflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.bind(book);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        final int RGB_MAX_VALUE = 255;
        final int ALPHA_BACKGROUND_VALUE = 64;

        ImageView bookImageView;
        TextView titleTextView;
        TextView authorTextView;
        TextView genreTextView;

        ViewHolder(FragmentLibraryBookItemBinding binding) {
            super(binding.getRoot());
            bookImageView = binding.bookImageView;
            titleTextView = binding.titleTextView;
            authorTextView = binding.authorTextView;
            genreTextView = binding.genreTextView;
            Random random = new Random();
            bookImageView.setBackgroundColor(
                    Color.argb(
                            ALPHA_BACKGROUND_VALUE,
                            random.nextInt(RGB_MAX_VALUE),
                            random.nextInt(RGB_MAX_VALUE),
                            random.nextInt(RGB_MAX_VALUE)
                    )
            );
        }

        public void bind(Book book) {
            titleTextView.setText(book.getTitle());
            authorTextView.setText(book.getAuthor());
            genreTextView.setText(book.getGenre());
        }
    }

    public static class Callback extends DiffUtil.Callback {

        List<Book> oldList;
        List<Book> newList;

        public Callback(List<Book> oldList, List<Book> newList) {
            this.oldList = oldList;
            this.newList = newList;
        }

        @Override
        public int getOldListSize() {
            return oldList.size();
        }

        @Override
        public int getNewListSize() {
            return newList.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            Book oldBook = oldList.get(oldItemPosition);
            Book newBook = newList.get(newItemPosition);
            return oldBook.getId() == newBook.getId();
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            Book oldBook = oldList.get(oldItemPosition);
            Book newBook = newList.get(newItemPosition);
            return oldBook.equals(newBook);
        }
    }
}
