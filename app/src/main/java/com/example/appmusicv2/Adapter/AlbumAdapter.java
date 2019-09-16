package com.example.appmusicv2.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Model.Album;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.ViewHolder> {

    Context context;
    ArrayList<Album> array_album;

    public AlbumAdapter(Context context, ArrayList<Album> array_album) {
        this.context = context;
        this.array_album = array_album;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_album,parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Album album = array_album.get(position);
        holder.textViewSinger.setText(album.getNameSinger());
        holder.textViewAlbum.setText(album.getNameAlbum());
        Picasso.get().load(album.getImageAlbum()).into(holder.imageViewAblum);
    }

    @Override
    public int getItemCount() {
        return array_album.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewAblum;
        TextView textViewAlbum, textViewSinger;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewAblum = itemView.findViewById(R.id.imageViewAlbum);
            textViewAlbum = itemView.findViewById(R.id.textviewNameAlbum);
            textViewSinger = itemView.findViewById(R.id.textViewNameSinger);
        }
    }
}
