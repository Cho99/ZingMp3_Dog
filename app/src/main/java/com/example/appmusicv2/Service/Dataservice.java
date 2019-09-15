package com.example.appmusicv2.Service;

import com.example.appmusicv2.Model.Banner;
import com.example.appmusicv2.Model.Playlist;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataservice {
    @GET("server/songbanner.php")
    Call<List<Banner>> GetDataBanner();

    @GET("/server/playlist.php")
     Call<List<Playlist>> GetDataPlayList();
}
