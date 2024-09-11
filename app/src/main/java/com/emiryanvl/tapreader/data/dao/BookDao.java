package com.emiryanvl.tapreader.data.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.emiryanvl.tapreader.data.entities.BookEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

@Dao
public interface BookDao {
    @Query("SELECT * FROM book")
    Observable<List<BookEntity>> findAll();

    @Query("SELECT * FROM book WHERE id = :id")
    Observable<BookEntity> findById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(BookEntity book);

    @Delete
    void delete(BookEntity book);
}
