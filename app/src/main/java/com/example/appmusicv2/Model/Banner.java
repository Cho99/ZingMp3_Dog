package com.example.appmusicv2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Banner {

@SerializedName("Id_advertisement")
@Expose
private String idAdvertisement;
@SerializedName("Image")
@Expose
private String image;
@SerializedName("Context")
@Expose
private String context;
@SerializedName("Id_song")
@Expose
private String idSong;
@SerializedName("Name_song")
@Expose
private String nameSong;
@SerializedName("Image_song")
@Expose
private String imageSong;

public String getIdAdvertisement() {
return idAdvertisement;
}

public void setIdAdvertisement(String idAdvertisement) {
this.idAdvertisement = idAdvertisement;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getContext() {
return context;
}

public void setContext(String context) {
this.context = context;
}

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

public String getImageSong() {
return imageSong;
}

public void setImageSong(String imageSong) {
this.imageSong = imageSong;
}

}