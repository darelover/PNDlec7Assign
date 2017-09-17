package com.example.atulsachdeva.pndlec7assign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.adapters.CommentsRecyclerAdapter;
import com.example.atulsachdeva.pndlec7assign.api.ApiService;
import com.example.atulsachdeva.pndlec7assign.models.Comment;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.atulsachdeva.pndlec7assign.R.id.tvUserId;

public class CommentsActivity extends AppCompatActivity {

    TextView tvPostId, tvTitle, tvBody;
    RecyclerView rvComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        tvPostId = (TextView) findViewById(R.id.tvPostId);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvBody = (TextView) findViewById(R.id.tvBody);

        tvPostId.setText(getIntent().getStringExtra("PostId"));
        tvTitle.setText(getIntent().getStringExtra("Title"));
        tvBody.setText(getIntent().getStringExtra("Body"));

        rvComments = (RecyclerView) findViewById(R.id.rvComments);
        rvComments.setLayoutManager(new LinearLayoutManager(this));

        final CommentsRecyclerAdapter commentsRecyclerAdapter = new CommentsRecyclerAdapter(this);
        rvComments.setAdapter(commentsRecyclerAdapter);

        ApiService.getApi().getCommentsOfPost(Integer.valueOf(getIntent().getStringExtra("PostId"))).enqueue(new Callback<ArrayList<Comment>>() {
            @Override
            public void onResponse(Call<ArrayList<Comment>> call, Response<ArrayList<Comment>> response) {
                commentsRecyclerAdapter.updateComments(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<Comment>> call, Throwable t) {

            }
        });
    }
}
