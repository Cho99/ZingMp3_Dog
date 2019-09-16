package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> array_song;

    public SongAdapter(Context context, ArrayList<Song> array_song) {
        this.context = context;
        this.array_song = array_song;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = array_song.get(position);
        holder.txtName.setText(song.getNameSong());
        holder.txtSinger.setText(song.getSinger());
        Picasso.get().load(song.getImgSong()).into(holder.imgSong);
    }

    @Override
    public int getItemCount() {
        return array_song.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtSinger;
        ImageView imgSong, imgLike;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.textviewNameHotSong);
            txtSinger = itemView.findViewById(R.id.textviewName_Singer_Hot);
            imgSong = itemView.findViewById(R.id.imageviewSongHot);
            imgLike = itemView.findViewById(R.id.imageviewLike);
        }
    }
}
