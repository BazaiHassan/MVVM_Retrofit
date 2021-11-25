package com.masterdev.mvvm_retrofit.banner;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerViewModel extends ViewModel {

    private ApiService apiService;
    private MutableLiveData<List<ResponseBanner>> banners = new MutableLiveData<>();
    private MutableLiveData<String> error = new MutableLiveData<>();
    private MutableLiveData<Boolean> progress = new MutableLiveData<>();

    public BannerViewModel(ApiService apiService) {
        this.apiService = apiService;

        apiService.getBanner().enqueue(new Callback<List<ResponseBanner>>() {
            @Override
            public void onResponse(Call<List<ResponseBanner>> call, Response<List<ResponseBanner>> response) {
                banners.setValue(response.body());
                progress.setValue(false);
            }

            @Override
            public void onFailure(Call<List<ResponseBanner>> call, Throwable t) {
                error.setValue("You Got An Error!");
                progress.setValue(false);
            }
        });
    }

    public LiveData<List<ResponseBanner>> getBanners() {
        return banners;
    }

    public LiveData<String> getError() {
        return error;
    }

    public LiveData<Boolean> getProgress() {
        return progress;
    }
}
