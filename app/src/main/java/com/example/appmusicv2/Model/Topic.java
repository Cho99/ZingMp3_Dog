package com.example.appmusicv2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Topic implements Serializable {

@SerializedName("Id_topic")
@Expose
private String idTopic;
@SerializedName("Name_topic")
@Expose
private String nameTopic;
@SerializedName("Image_topic")
@Expose
private String imageTopic;

public String getIdTopic() {
return idTopic;
}

public void setIdTopic(String idTopic) {
this.idTopic = idTopic;
}

public String getNameTopic() {
return nameTopic;
}

public void setNameTopic(String nameTopic) {
this.nameTopic = nameTopic;
}

public String getImageTopic() {
return imageTopic;
}

public void setImageTopic(String imageTopic) {
this.imageTopic = imageTopic;
}

}