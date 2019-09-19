package com.example.appmusicv2.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appmusicv2.Model.Playlist;
import com.example.appmusicv2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayListAdapter extends ArrayAdapter<Playlist> {
    public PlayListAdapter(@NonNull Context context, int resource, @NonNull List<Playlist> objects) {
        super(context, resource, objects);
    }

    class ViewHolder {
        TextView txtNamePlayList;
        ImageView imgPlayList;
        ImageView imgButtonBackGroud;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.row_playlist, null);
            viewHolder = new ViewHolder();
            viewHolder.txtNamePlayList = convertView.findViewById(R.id.textviewNamePlayList);
            viewHolder.imgButtonBackGroud = convertView.findViewById(R.id.imageButtonPlayList);
            viewHolder.imgPlayList = convertView.findViewById(R.id.imageviewPlayList);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Playlist playlist = getItem(position);
        Picasso.get().load(playlist.getImagePlayList()).into(viewHolder.imgButtonBackGroud);
        Picasso.get().load(playlist.getIcon()).into(viewHolder.imgPlayList);
        viewHolder.txtNamePlayList.setText(playlist.getName());
        return convertView;
    }
}
