package com.example.atulsachdeva.pndlec7assign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.atulsachdeva.pndlec7assign.activities.AlbumsActivity;
import com.example.atulsachdeva.pndlec7assign.activities.PostsActivity;
import com.example.atulsachdeva.pndlec7assign.activities.TodosActivity;
import com.example.atulsachdeva.pndlec7assign.activities.UsersActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.ivPosts).setOnClickListener(this);
        findViewById(R.id.ivAlbums).setOnClickListener(this);
        findViewById(R.id.ivTodos).setOnClickListener(this);
        findViewById(R.id.ivUsers).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.ivPosts:
                startActivity(new Intent(this, PostsActivity.class));
                break;
            case R.id.ivAlbums:
                startActivity(new Intent(this, AlbumsActivity.class));
                break;
            case R.id.ivTodos:
                startActivity(new Intent(this, TodosActivity.class));
                break;
            case R.id.ivUsers:
                startActivity(new Intent(this, UsersActivity.class));
                break;
        }

    }
}
