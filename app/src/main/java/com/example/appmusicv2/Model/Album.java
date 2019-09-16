package com.example.appmusicv2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

@SerializedName("Id_album")
@Expose
private String idAlbum;
@SerializedName("Name_album")
@Expose
private String nameAlbum;
@SerializedName("Name_singer")
@Expose
private String nameSinger;
@SerializedName("Image_album")
@Expose
private String imageAlbum;

public String getIdAlbum() {
return idAlbum;
}

public void setIdAlbum(String idAlbum) {
this.idAlbum = idAlbum;
}

public String getNameAlbum() {
return nameAlbum;
}

public void setNameAlbum(String nameAlbum) {
this.nameAlbum = nameAlbum;
}

public String getNameSinger() {
return nameSinger;
}

public void setNameSinger(String nameSinger) {
this.nameSinger = nameSinger;
}

public String getImageAlbum() {
return imageAlbum;
}

public void setImageAlbum(String imageAlbum) {
this.imageAlbum = imageAlbum;
}

}