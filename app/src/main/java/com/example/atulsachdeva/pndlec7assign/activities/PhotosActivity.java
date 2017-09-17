package com.example.atulsachdeva.pndlec7assign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.adapters.PhotosRecyclerAdapter;
import com.example.atulsachdeva.pndlec7assign.api.ApiService;
import com.example.atulsachdeva.pndlec7assign.models.Photo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosActivity extends AppCompatActivity {

    TextView tvAlbumId, tvTitle;
    RecyclerView rvPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photos);

        tvAlbumId = (TextView) findViewById(R.id.tvAlbumId);
        tvTitle = (TextView) findViewById(R.id.tvTitle);

        tvAlbumId.setText(getIntent().getStringExtra("AlbumId"));
        tvTitle.setText(getIntent().getStringExtra("Title"));

        rvPhotos = (RecyclerView) findViewById(R.id.rvPhotos);
        rvPhotos.setLayoutManager(new LinearLayoutManager(this));

        final PhotosRecyclerAdapter photosRecyclerAdapter = new PhotosRecyclerAdapter(this);
        rvPhotos.setAdapter(photosRecyclerAdapter);

        ApiService.getApi().getPhotosOfAlbum(Integer.valueOf(getIntent().getStringExtra("AlbumId"))).enqueue(new Callback<ArrayList<Photo>>() {
            @Override
            public void onResponse(Call<ArrayList<Photo>> call, Response<ArrayList<Photo>> response) {
                photosRecyclerAdapter.updatePhotos(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Photo>> call, Throwable t) {

            }
        });
    }
}
