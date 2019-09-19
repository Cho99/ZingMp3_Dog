package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Model.Topic;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAllTopic extends RecyclerView.Adapter<ListAllTopic.ViewHolder>{

    Context context;
    ArrayList<Topic> array_topic;

    public ListAllTopic(Context context, ArrayList<Topic> array_topic) {
        this.context = context;
        this.array_topic = array_topic;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_list_alltopic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Topic topic = array_topic.get(position);
        Picasso.get().load(topic.getImageTopic()).into(holder.imgToppic);
    }

    @Override
    public int getItemCount() {
        return array_topic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgToppic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgToppic = itemView.findViewById(R.id.imagaviewRowTopic);
        }
    }
}
