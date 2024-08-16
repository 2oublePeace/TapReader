package com.emiryanvl.tapreader;

import android.app.Application;

import com.emiryanvl.tapreader.di.AppComponent;
import com.emiryanvl.tapreader.di.DaggerAppComponent;


public class App extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().application(this).build();
    }

    public static AppComponent appComponent() {
        return appComponent;
    }
}
