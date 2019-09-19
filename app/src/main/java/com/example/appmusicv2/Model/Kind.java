package com.example.appmusicv2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Kind implements Serializable {

@SerializedName("Id_Kind")
@Expose
private String idKind;
@SerializedName("Id_Key_Topic")
@Expose
private String idKeyTopic;
@SerializedName("Name_Kind")
@Expose
private String nameKind;
@SerializedName("Image_kind")
@Expose
private String imageKind;

public String getIdKind() {
return idKind;
}

public void setIdKind(String idKind) {
this.idKind = idKind;
}

public String getIdKeyTopic() {
return idKeyTopic;
}

public void setIdKeyTopic(String idKeyTopic) {
this.idKeyTopic = idKeyTopic;
}

public String getNameKind() {
return nameKind;
}

public void setNameKind(String nameKind) {
this.nameKind = nameKind;
}

public String getImageKind() {
return imageKind;
}

public void setImageKind(String imageKind) {
this.imageKind = imageKind;
}

}