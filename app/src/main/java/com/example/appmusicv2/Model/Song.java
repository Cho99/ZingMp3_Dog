package com.example.appmusicv2.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Song implements Parcelable {

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

    protected Song(Parcel in) {
        idSong = in.readString();
        nameSong = in.readString();
        imgSong = in.readString();
        singer = in.readString();
        linkSong = in.readString();
        like = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(idSong);
        parcel.writeString(nameSong);
        parcel.writeString(imgSong);
        parcel.writeString(singer);
        parcel.writeString(linkSong);
        parcel.writeString(like);
    }
}