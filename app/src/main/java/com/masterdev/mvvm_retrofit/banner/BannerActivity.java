package com.masterdev.mvvm_retrofit.banner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.masterdev.mvvm_retrofit.R;

import java.util.List;

public class BannerActivity extends AppCompatActivity {

    private RecyclerView rvBanner;
    private ProgressBar progressBar;
    private AdapterBanner adapterBanner;
    private BannerViewModel bannerViewModel;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        findViews();
        bannerViewModel = new ViewModelProvider(this, new BannerViewModelFactory()).get(BannerViewModel.class);
        bannerViewModel.getBanners().observe(this, new Observer<List<ResponseBanner>>() {
            @Override
            public void onChanged(List<ResponseBanner> responseBanners) {
                adapterBanner = new AdapterBanner(responseBanners);
                rvBanner.setAdapter(adapterBanner);
            }
        });

        bannerViewModel.getError().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(BannerActivity.this, s, Toast.LENGTH_SHORT).show();
            }
        });

        bannerViewModel.getProgress().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    progressBar.setVisibility(View.VISIBLE);
                }else {
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

    private void findViews() {
        rvBanner = findViewById(R.id.rv_banner);
        rvBanner.setLayoutManager(new LinearLayoutManager(this));
        progressBar = findViewById(R.id.progress_bar);
    }
}