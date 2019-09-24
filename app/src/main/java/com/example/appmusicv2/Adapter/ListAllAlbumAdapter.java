package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Activity.ListSongActivity;
import com.example.appmusicv2.Model.Album;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListAllAlbumAdapter extends RecyclerView.Adapter<ListAllAlbumAdapter.ViewHolder> {
    Context context;
    ArrayList<Album> albums;

    public ListAllAlbumAdapter(Context context, ArrayList<Album> albums) {
        this.context = context;
        this.albums = albums;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row_all_album, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Album album = albums.get(position);
        Picasso.get().load(album.getImageAlbum()).into(holder.imageView);
        holder.txtName.setText(album.getNameAlbum());
        holder.txtSinger.setText(album.getNameSinger());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView txtName, txtSinger;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageviewAllAlbum);
            txtName = itemView.findViewById(R.id.tetxviewNameAllAlbum);
            txtSinger = itemView.findViewById(R.id.textviewnameSingerAllAlbum);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("album", albums.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }

}
