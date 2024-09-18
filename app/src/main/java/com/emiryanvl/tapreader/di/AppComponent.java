package com.emiryanvl.tapreader.di;

import com.emiryanvl.tapreader.App;
import com.emiryanvl.tapreader.MainActivity;
import com.emiryanvl.tapreader.ui.fragments.BaseFragment;
import com.emiryanvl.tapreader.ui.fragments.LibraryFragment;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = {
    DataModule.class,
    NetworkModule.class,
    BindModule.class
})
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

    void inject(App app);
}