package com.masterdev.mvvm_retrofit.banner;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BannerViewModelFactory implements ViewModelProvider.Factory {

    private ApiService apiService;

    public BannerViewModelFactory() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://novindevelopers.ir").addConverterFactory(GsonConverterFactory.create()).build();
        apiService = retrofit.create(ApiService.class);
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BannerViewModel(apiService);
    }
}
