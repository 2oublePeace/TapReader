package com.emiryanvl.tapreader.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.emiryanvl.tapreader.data.entities.BookEntity;

import java.util.List;

@Dao
public interface BookDao {
    @Query("SELECT * FROM book")
    List<BookEntity> findAll();

    @Query("SELECT * FROM book WHERE id = :id")
    BookEntity findById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(BookEntity book);

    @Delete
    void delete(BookEntity book);
}
