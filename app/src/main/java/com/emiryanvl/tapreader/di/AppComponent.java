package com.emiryanvl.tapreader.di;

import android.content.Context;

import com.emiryanvl.tapreader.App;
import com.emiryanvl.tapreader.MainActivity;
import com.emiryanvl.tapreader.ui.fragments.AddBookFragment;
import com.emiryanvl.tapreader.ui.fragments.LibraryFragment;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules={DataModule.class})
@Singleton
public interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(App application);
        AppComponent build();
    }
    void inject(MainActivity mainActivity);
    void inject(LibraryFragment libraryFragment);
    void inject(AddBookFragment addBookFragment);
    void inject(App app);
}