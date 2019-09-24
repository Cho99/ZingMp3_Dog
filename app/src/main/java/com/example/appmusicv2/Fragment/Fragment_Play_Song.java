package com.example.appmusicv2.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Activity.PlaySongActivity;
import com.example.appmusicv2.Adapter.PlaySongAdapter;
import com.example.appmusicv2.R;

public class Fragment_Play_Song extends Fragment {

    View view;
    RecyclerView recyclerView;
    PlaySongAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play_song, container, false);
        recyclerView = view.findViewById(R.id.recyclerNamePlaySong);
        if (PlaySongActivity.arrayList_song.size() > 0) {
            adapter = new PlaySongAdapter(getActivity(), PlaySongActivity.arrayList_song);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
}
