package com.emiryanvl.tapreader.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewbinding.ViewBinding;

public abstract class BaseFragment<T extends ViewBinding, V extends Fragment> extends Fragment {

    protected T binding;
    protected NavController navController;

    protected abstract BindingInflater<T> getBinding();

    @Override
    public View onCreateView(
        @NonNull LayoutInflater inflater,
        ViewGroup container,
        Bundle savedInstanceState
    ) {
        binding = getBinding().inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        initializeViews();
    }

    protected void initializeViews() {}

    protected <U> void observeData(LiveData<U> liveData, LiveDataObserver observer) {
        liveData.observe(this, object -> observer.callback());
    }

    @FunctionalInterface
    protected interface LiveDataObserver {
        void callback();
    }

    @FunctionalInterface
    protected interface BindingInflater<T> {
        T inflate(LayoutInflater inflater, ViewGroup container, boolean attachToParrent);
    }
}

