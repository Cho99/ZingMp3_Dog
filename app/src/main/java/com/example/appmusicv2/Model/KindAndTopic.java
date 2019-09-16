package com.example.appmusicv2.Model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KindAndTopic {

@SerializedName("Kind")
@Expose
private List<Kind> kind = null;
@SerializedName("Topic")
@Expose
private List<Topic> topic = null;

public List<Kind> getKind() {
return kind;
}

public void setKind(List<Kind> kind) {
this.kind = kind;
}

public List<Topic> getTopic() {
return topic;
}

public void setTopic(List<Topic> topic) {
this.topic = topic;
}

}