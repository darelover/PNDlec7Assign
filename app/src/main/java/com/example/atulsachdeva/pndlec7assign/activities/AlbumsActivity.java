package com.example.atulsachdeva.pndlec7assign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.adapters.AlbumsRecyclerAdapter;
import com.example.atulsachdeva.pndlec7assign.api.ApiService;
import com.example.atulsachdeva.pndlec7assign.models.Album;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumsActivity extends AppCompatActivity {

    RecyclerView rvAlbums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        rvAlbums = (RecyclerView) findViewById(R.id.rvAlbums);
        rvAlbums.setLayoutManager(new LinearLayoutManager(this));

        final AlbumsRecyclerAdapter albumsRecyclerAdapter = new AlbumsRecyclerAdapter(this);
        rvAlbums.setAdapter(albumsRecyclerAdapter);

        String userId = getIntent().getStringExtra("UserId");

        if(userId == null) {

            ApiService.getApi().getAlbums().enqueue(new Callback<ArrayList<Album>>() {
                @Override
                public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                    albumsRecyclerAdapter.updateAlbums(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

                }
            });
        }
        else {
            ApiService.getApi().getAlbumsOfUser(Integer.valueOf(userId)).enqueue(new Callback<ArrayList<Album>>() {
                @Override
                public void onResponse(Call<ArrayList<Album>> call, Response<ArrayList<Album>> response) {
                    albumsRecyclerAdapter.updateAlbums(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Album>> call, Throwable t) {

                }
            });
        }
    }
}
