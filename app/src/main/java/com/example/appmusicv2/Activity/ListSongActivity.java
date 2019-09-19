package com.example.appmusicv2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appmusicv2.Adapter.ListSongAdapter;
import com.example.appmusicv2.Model.Banner;
import com.example.appmusicv2.Model.Kind;
import com.example.appmusicv2.Model.Playlist;
import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.R;
import com.example.appmusicv2.Service.APIService;
import com.example.appmusicv2.Service.Dataservice;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class ListSongActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    CollapsingToolbarLayout collapsingToolbarLayout;
    Toolbar toolbar;
    RecyclerView recyclerView;
    FloatingActionButton floatingActionButton;
    ImageView imageView;
    Banner banner;
    Playlist playlist;
    Kind kind;
    ArrayList<Song> array_song;
    ListSongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_song);
        AnhXa();
        DataIntent();
        init();
        if (banner != null && !banner.getNameSong().equals("")) {
            setValueInView(banner.getNameSong(), banner.getImageSong());
            GetDataBanner(banner.getIdAdvertisement());
        }
        if (playlist != null && !playlist.getName().equals("")) {
            setValueInView(playlist.getName(), playlist.getImagePlayList());
            GetDataPlayList(playlist.getIdPlayList());
        }
        if (kind != null && !kind.getNameKind().equals("")) {
            setValueInView(kind.getNameKind(), kind.getImageKind());
            GetDataKind(kind.getIdKind());
        }

    }

    private void GetDataKind(String idKind) {
        Dataservice dataservice = APIService.getService();
        Call<List<Song>> callback = dataservice.GetDataKindSong(idKind);
        callback.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                array_song = (ArrayList<Song>) response.body();
                adapter = new ListSongAdapter(ListSongActivity.this, array_song);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerView.setAdapter(adapter);
            }
            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });


    }

    private void GetDataPlayList(String idPlayList) {
        Dataservice dataservice = APIService.getService();
        Call<List<Song>> call = dataservice.GetListSongPlayList(idPlayList);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                array_song = (ArrayList<Song>) response.body();
                adapter = new ListSongAdapter(ListSongActivity.this, array_song);
                recyclerView.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }

    private void setValueInView(String name, String image) {
        collapsingToolbarLayout.setTitle(name);
        try {
            URL url = new URL(image);
//            Bitmap bitmap = new Bitmap(url.openConnection().getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void GetDataBanner(String idAdvertisement) {
        Dataservice dataservice = APIService.getService();
        Call<List<Song>> call = dataservice.GetListSongBanner(idAdvertisement);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
              array_song = (ArrayList<Song>) response.body();
              Toast.makeText(ListSongActivity.this, array_song.get(0).getNameSong(), Toast.LENGTH_SHORT).show();
              adapter = new ListSongAdapter(ListSongActivity.this, array_song);
              recyclerView.setLayoutManager(new LinearLayoutManager(ListSongActivity.this));
              recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });

    }

    private void init() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
    }

    private void AnhXa() {
        coordinatorLayout = findViewById(R.id.coordinatorListSong);
        collapsingToolbarLayout = findViewById(R.id.collpastingtoobarListSong);
        toolbar = findViewById(R.id.toolbarListSongBanner);
        recyclerView = findViewById(R.id.recyclerListSong);
        floatingActionButton = findViewById(R.id.floatingactionbuttonListSong);
        imageView = findViewById(R.id.imageListSongLike);
    }

    private void DataIntent() {
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("data")) {
                banner = (Banner) intent.getSerializableExtra("data");
            }
            if (intent.hasExtra("iteamplaylist")) {
                playlist = (Playlist) intent.getSerializableExtra("iteamplaylist");
            }
            if (intent.hasExtra("idkind")) {
               kind = (Kind) intent.getSerializableExtra("idkind");
            }
        }
    }
}
