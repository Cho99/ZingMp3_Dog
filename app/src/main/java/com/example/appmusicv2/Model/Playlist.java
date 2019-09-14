package com.example.appmusicv2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Playlist {

@SerializedName("IdPlayList")
@Expose
private String idPlayList;
@SerializedName("Name")
@Expose
private String name;
@SerializedName("ImagePlayList")
@Expose
private String imagePlayList;
@SerializedName("Icon")
@Expose
private String icon;

public String getIdPlayList() {
return idPlayList;
}

public void setIdPlayList(String idPlayList) {
this.idPlayList = idPlayList;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getImagePlayList() {
return imagePlayList;
}

public void setImagePlayList(String imagePlayList) {
this.imagePlayList = imagePlayList;
}

public String getIcon() {
return icon;
}

public void setIcon(String icon) {
this.icon = icon;
}

}