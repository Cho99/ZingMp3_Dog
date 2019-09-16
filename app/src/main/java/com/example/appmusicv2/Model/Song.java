package com.example.appmusicv2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Song {

@SerializedName("Id_Song")
@Expose
private String idSong;
@SerializedName("Name_song")
@Expose
private String nameSong;
@SerializedName("Img_song")
@Expose
private String imgSong;
@SerializedName("Singer")
@Expose
private String singer;
@SerializedName("Link_song")
@Expose
private String linkSong;
@SerializedName("Like")
@Expose
private String like;

public String getIdSong() {
return idSong;
}

public void setIdSong(String idSong) {
this.idSong = idSong;
}

public String getNameSong() {
return nameSong;
}

public void setNameSong(String nameSong) {
this.nameSong = nameSong;
}

public String getImgSong() {
return imgSong;
}

public void setImgSong(String imgSong) {
this.imgSong = imgSong;
}

public String getSinger() {
return singer;
}

public void setSinger(String singer) {
this.singer = singer;
}

public String getLinkSong() {
return linkSong;
}

public void setLinkSong(String linkSong) {
this.linkSong = linkSong;
}

public String getLike() {
return like;
}

public void setLike(String like) {
this.like = like;
}

}