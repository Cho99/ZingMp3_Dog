package com.example.appmusicv2.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmusicv2.Adapter.SearchSongAdapeter;
import com.example.appmusicv2.Model.Song;
import com.example.appmusicv2.R;
import com.example.appmusicv2.Service.APIService;
import com.example.appmusicv2.Service.Dataservice;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_Tim_kiem extends Fragment {

    View view;
    Toolbar toolbar;
    RecyclerView recyclerView;
    TextView txtKhongCoDuLieu;
    SearchSongAdapeter searchSongAdapeter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tim_kiem, container, false);
        toolbar = view.findViewById(R.id.toolbarSearch);
        recyclerView = view.findViewById(R.id.recyclerSearchSong);
        txtKhongCoDuLieu = view.findViewById(R.id.textviewNone);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle("");
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.search_view, menu);
        MenuItem menuItem = menu.findItem(R.id.menuSearch);
        SearchView searchView = (androidx.appcompat.widget.SearchView) menuItem.getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SearchKeySong(query);
                return true;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        super.onCreateOptionsMenu(menu, inflater);
    }
    private void SearchKeySong(String query) {
        Dataservice dataservice = APIService.getService();
        Call<List<Song>> call = dataservice.GetSearchSong(query);
        call.enqueue(new Callback<List<Song>>() {
            @Override
            public void onResponse(Call<List<Song>> call, Response<List<Song>> response) {
                ArrayList<Song> array_song = (ArrayList<Song>) response.body();
                if (array_song.size() > 0) {
                    searchSongAdapeter = new SearchSongAdapeter(getActivity(), array_song);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(searchSongAdapeter);
                    txtKhongCoDuLieu.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);
                }else {
                    txtKhongCoDuLieu.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<Song>> call, Throwable t) {

            }
        });
    }
}
