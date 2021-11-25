package com.masterdev.mvvm_retrofit.banner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.masterdev.mvvm_retrofit.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterBanner extends RecyclerView.Adapter<AdapterBanner.BannerViewHolder>{

    private List<ResponseBanner> responseBanners = new ArrayList<>();

    public AdapterBanner(List<ResponseBanner> responseBanners) {
        this.responseBanners = responseBanners;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterBanner.BannerViewHolder holder, int position) {
        holder.bindBanners(responseBanners.get(position));
    }

    @Override
    public int getItemCount() {
        return responseBanners.size();
    }

    public class BannerViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgBanner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);

            imgBanner = itemView.findViewById(R.id.img_banner);
        }

        private void bindBanners(ResponseBanner banner){
            Glide.with(itemView).load(banner.getBanner()).into(imgBanner);
        }
    }
}
