package com.masterdev.mvvm_retrofit.banner;

import com.google.gson.annotations.SerializedName;

public class ResponseBanner {

    @SerializedName("image")
    private String image;

    @SerializedName("id")
    private int id;

    public String getBanner(){
        return image;
    }

    public int getId(){
        return id;
    }

}
