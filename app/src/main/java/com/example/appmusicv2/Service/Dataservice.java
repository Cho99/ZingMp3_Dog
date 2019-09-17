package com.example.appmusicv2.Service;

import com.example.appmusicv2.Model.Album;
import com.example.appmusicv2.Model.Banner;
import com.example.appmusicv2.Model.KindAndTopic;
import com.example.appmusicv2.Model.Playlist;
import com.example.appmusicv2.Model.Song;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
    @GET("server/songbanner.php")
    Call<List<Banner>> GetDataBanner();

    @GET("server/playlist.php")
     Call<List<Playlist>> GetDataPlayList();

    @GET("server/topicandkind.php")
    Call<KindAndTopic> GetCategoryMusic();

    @GET("server/albumhot.php")
    Call<List<Album>> GetDataAlbum();

    @GET("server/song.php")
    Call<List<Song>> GetDataSong();

    @FormUrlEncoded
    @POST("server/listsong.php")
    Call<List<Song>> GetListSongBanner(@Field("id_advertisement") String id_advertisement);

}
