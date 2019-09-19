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
import com.example.appmusicv2.Model.Playlist;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListPlayListAdapter extends RecyclerView.Adapter<ListPlayListAdapter.ViewHolder> {

    Context context;
    ArrayList<Playlist> array_playlist;

    public ListPlayListAdapter(Context context, ArrayList<Playlist> array_playlist) {
        this.context = context;
        this.array_playlist = array_playlist;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_list_playlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Playlist playlist = array_playlist.get(position);
        Picasso.get().load(playlist.getImagePlayList()).into(holder.img);
        holder.txtNamePlayList.setText(playlist.getName());
    }

    @Override
    public int getItemCount() {
        return array_playlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView txtNamePlayList;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imageviewListPlayList);
            txtNamePlayList = itemView.findViewById(R.id.tetxviewNameListPlayList);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ListSongActivity.class);
                    intent.putExtra("iteamplaylist", array_playlist.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
