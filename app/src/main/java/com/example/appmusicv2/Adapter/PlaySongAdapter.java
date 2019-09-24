package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.R;

import java.util.ArrayList;

public class PlaySongAdapter extends RecyclerView.Adapter<PlaySongAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> array_song;

    public PlaySongAdapter(Context context, ArrayList<Song> array_song) {
        this.context = context;
        this.array_song = array_song;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_play_song,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Song song = array_song.get(position);
        holder.txtSong.setText(song.getNameSong());
        holder.txtSinger.setText(song.getSinger());
        holder.txtIndex.setText(position + 1 + "");
    }

    @Override
    public int getItemCount() {
        return array_song.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtIndex, txtSong, txtSinger;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtIndex = itemView.findViewById(R.id.textviewPlaySongIndex);
            txtSong = itemView.findViewById(R.id.textviewPlaySongName);
            txtSinger = itemView.findViewById(R.id.textviewPlaySongSinger);


        }
    }
}
