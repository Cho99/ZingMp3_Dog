package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Activity.PlayListActivity;
import com.example.appmusicv2.Activity.PlaySongActivity;
import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.R;
import com.example.appmusicv2.Service.APIService;
import com.example.appmusicv2.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchSongAdapeter extends RecyclerView.Adapter<SearchSongAdapeter.ViewHolder> {
    Context context;
    ArrayList<Song> array_song;

    public SearchSongAdapeter(Context context, ArrayList<Song> array_song) {
        this.context = context;
        this.array_song = array_song;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_search_song, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song =array_song.get(position);
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
            txtName = itemView.findViewById(R.id.textviewSearchSong);
            txtSinger = itemView.findViewById(R.id.textviewSearchSinger);
            imgSong = itemView.findViewById(R.id.imageviewSearch);
            imgLike = itemView.findViewById(R.id.imageSearchLike);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, PlaySongActivity.class);
                    intent.putExtra("song", array_song.get(getPosition()));
                    context.startActivity(intent);
                }
            });
            imgLike.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    imgLike.setImageResource(R.drawable.like);
                    Dataservice dataservice = APIService.getService();
                    Call<String> call = dataservice.UpateLike(array_song.get(getPosition()).getIdSong(), "1");
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result = response.body();
                            if (result.equals("Success")) {
                                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
                            }
                        }
                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Toast.makeText(context, "Lỗi!", Toast.LENGTH_SHORT).show();
                        }
                    });
                    imgLike.setEnabled(false);
                }
            });
        }
    }

}
