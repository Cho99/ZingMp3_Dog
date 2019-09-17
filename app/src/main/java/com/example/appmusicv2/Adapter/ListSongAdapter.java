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

import java.util.ArrayList;

public class ListSongAdapter extends RecyclerView.Adapter<ListSongAdapter.ViewHolder> {
    Context context;
    ArrayList<Song> array_song;

    public ListSongAdapter(Context context, ArrayList<Song> array_song) {
        this.context = context;
        this.array_song = array_song;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_listsong, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = array_song.get(position);
        holder.txtIndex.setText(position+1+"");
        holder.txtSinger.setText(song.getSinger());
        holder.txtNameSong.setText(song.getNameSong());
    }

    @Override
    public int getItemCount() {
        return array_song.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtIndex, txtNameSong, txtSinger;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSinger = itemView.findViewById(R.id.textviewListSongSinger);
            txtIndex = itemView.findViewById(R.id.textviewListSongIndex);
            txtNameSong = itemView.findViewById(R.id.texviewListSongName);
            imageView = itemView.findViewById(R.id.imageListSongLike);
        }
    }
}
