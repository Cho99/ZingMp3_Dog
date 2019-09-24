package com.example.appmusicv2.Service;

import com.example.appmusicv2.Model.Album;
import com.example.appmusicv2.Model.Banner;
import com.example.appmusicv2.Model.Kind;
import com.example.appmusicv2.Model.KindAndTopic;
import com.example.appmusicv2.Model.Playlist;
import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.Model.Topic;

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

    @FormUrlEncoded
    @POST("server/listsong.php")
    Call<List<Song>> GetListSongPlayList(@Field("id_playlist") String id_playlist);

    @GET("server/playlist.php")
    Call<List<Playlist>> GetPlayList();

    @FormUrlEncoded
    @POST("server/listsong.php")
    Call<List<Song>> GetDataKindSong(@Field("id_kind") String id_kind);

    @GET("server/all_topic.php")
    Call<List<Topic>> GetAllTopic();

    @FormUrlEncoded
    @POST("server/categoriesbysubject.php")
    Call<List<Kind>> GetDataCatergoryBySubject(@Field("id_topic") String id_topic);

    @GET("server/all_album.php")
    Call<List<Album>> GetDataAllAlbum();

    @FormUrlEncoded
    @POST("server/listsong.php")
    Call<List<Song>> GetDataListSongAlbum(@Field("id_album") String id_album);

    @FormUrlEncoded
    @POST("server/update_like.php")
    Call<String> UpateLike(@Field("id_song") String id_song, @Field("like") String like);

}
