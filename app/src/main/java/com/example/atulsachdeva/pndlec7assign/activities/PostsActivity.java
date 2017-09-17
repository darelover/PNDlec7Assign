package com.example.atulsachdeva.pndlec7assign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.adapters.PostsRecyclerAdapter;
import com.example.atulsachdeva.pndlec7assign.api.ApiService;
import com.example.atulsachdeva.pndlec7assign.models.Comment;
import com.example.atulsachdeva.pndlec7assign.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsActivity extends AppCompatActivity {

    RecyclerView rvPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);

        rvPosts = (RecyclerView) findViewById(R.id.rvPosts);
        rvPosts.setLayoutManager(new LinearLayoutManager(this));

        final PostsRecyclerAdapter postsRecyclerAdapter = new PostsRecyclerAdapter(this);
        rvPosts.setAdapter(postsRecyclerAdapter);

        String userId = getIntent().getStringExtra("UserId");
        if( userId == null) {

            ApiService.getApi().getPosts().enqueue(new Callback<ArrayList<Post>>() {
                @Override
                public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                    postsRecyclerAdapter.updatePosts(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                }
            });
        }
        else {
            ApiService.getApi().getPostsOfUser(Integer.valueOf(userId)).enqueue(new Callback<ArrayList<Post>>() {
                @Override
                public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {
                    postsRecyclerAdapter.updatePosts(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

                }
            });
        }
    }
}
