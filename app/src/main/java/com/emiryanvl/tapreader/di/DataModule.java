package com.emiryanvl.tapreader.di;

import android.content.Context;

import androidx.room.Room;

import com.emiryanvl.tapreader.App;
import com.emiryanvl.tapreader.data.AppDatabase;
import com.emiryanvl.tapreader.data.dao.BookDao;
import com.emiryanvl.tapreader.data.repositories.BookRepositoryImpl;
import com.emiryanvl.tapreader.domain.repositories.BookRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    Context provideContext(App app) {
        return app.getApplicationContext();
    }

    @Singleton
    @Provides
    AppDatabase provideAppDatabase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, "tap_reader_database")
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    BookDao provideBookDao(AppDatabase appDatabase) {
        return appDatabase.bookDao();
    }

    @Provides
    BookRepositoryImpl provideBookRepositoryImpl(BookDao bookDao) {
        return new BookRepositoryImpl(bookDao);
    }

    @Provides
    BookRepository provideBookRepository(BookRepositoryImpl bookRepositoryImpl) {
        return bookRepositoryImpl;
    }
}
