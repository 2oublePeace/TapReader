package com.emiryanvl.tapreader.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.emiryanvl.tapreader.data.local.dao.BookDao;
import com.emiryanvl.tapreader.data.local.entities.BookEntity;

@Database(entities = {BookEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
}
