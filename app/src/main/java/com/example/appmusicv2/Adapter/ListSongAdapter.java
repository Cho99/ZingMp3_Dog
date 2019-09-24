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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Toast.makeText(context, array_song.get(getPosition()).getNameSong(), Toast.LENGTH_SHORT).show();
                    imageView.setImageResource(R.drawable.like);
                    Dataservice dataservice = APIService.getService();
                    Call<String> call = dataservice.UpateLike(array_song.get(getPosition()).getIdSong(), "1");
                    call.enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {
                            String result = response.body();
                            if (result.equals("Success")) {
                                Toast.makeText(context, "Like", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Lỗi!", Toast.LENGTH_SHORT).show();

                            }
                        }
                        @Override
                        public void onFailure(Call<String> call, Throwable t) {

                        }
                    });
                    imageView.setEnabled(false);
                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, PlaySongActivity.class);
                    intent.putExtra("song", array_song.get(getPosition()));
                    context.startActivity(intent);
                }
            });
        }
    }
}
