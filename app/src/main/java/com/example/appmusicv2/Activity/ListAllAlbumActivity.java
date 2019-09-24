package com.example.appmusicv2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.appmusicv2.Adapter.ListAllAlbumAdapter;
import com.example.appmusicv2.Model.Album;
import com.example.appmusicv2.R;
import com.example.appmusicv2.Service.APIService;
import com.example.appmusicv2.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListAllAlbumActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    ListAllAlbumAdapter allAlbumAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all_album);
        init();
        GetData();
    }

    private void GetData() {
        Dataservice dataservice = APIService.getService();
        Call<List<Album>> call = dataservice.GetDataAllAlbum();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                ArrayList<Album> array_album = (ArrayList<Album>) response.body();
                allAlbumAdapter = new ListAllAlbumAdapter(ListAllAlbumActivity.this, array_album);
                recyclerView.setLayoutManager(new GridLayoutManager(ListAllAlbumActivity.this, 2));
                recyclerView.setAdapter(allAlbumAdapter);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });

    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerallAlbum);
        toolbar = findViewById(R.id.toolbarallAlbum);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Album");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
