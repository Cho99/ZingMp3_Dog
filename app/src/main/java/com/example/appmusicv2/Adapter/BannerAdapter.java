package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.appmusicv2.Model.Banner;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Banner> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Banner> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_banner, null);
        ImageView imgBackGroudBanner = view.findViewById(R.id.imageviewBackgroudBanner);
        ImageView imgSongBanner = view.findViewById(R.id.imageviewBanner);
        TextView textTitelBanner = view.findViewById(R.id.textviewTitleBanner);
        TextView txtContext = view.findViewById(R.id.textviewContext);

        Picasso.get().load(arrayListbanner.get(position).getImage()).into(imgBackGroudBanner);
        Picasso.get().load(arrayListbanner.get(position).getImageSong()).into(imgSongBanner);
        textTitelBanner.setText(arrayListbanner.get(position).getNameSong());
        txtContext.setText(arrayListbanner.get(position).getContext());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
