package com.masterdev.mvvm_retrofit.banner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("banner.php")
    Call<List<ResponseBanner>> getBanner();
}
