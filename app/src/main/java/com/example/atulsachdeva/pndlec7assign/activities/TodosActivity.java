package com.example.atulsachdeva.pndlec7assign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.adapters.TodosRecyclerAdapter;
import com.example.atulsachdeva.pndlec7assign.api.ApiService;
import com.example.atulsachdeva.pndlec7assign.models.Todo;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TodosActivity extends AppCompatActivity {

    RecyclerView rvTodos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todos);

        rvTodos = (RecyclerView) findViewById(R.id.rvTodos);
        rvTodos.setLayoutManager(new LinearLayoutManager(this));

        final TodosRecyclerAdapter todosRecyclerAdapter = new TodosRecyclerAdapter(this);
        rvTodos.setAdapter(todosRecyclerAdapter);

        String userId = getIntent().getStringExtra("UserId");

        if(userId == null) {
            ApiService.getApi().getTodos().enqueue(new Callback<ArrayList<Todo>>() {
                @Override
                public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                    todosRecyclerAdapter.updateTodos(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

                }
            });
        }
        else{

            ApiService.getApi().getTodosOfUser(Integer.valueOf(userId)).enqueue(new Callback<ArrayList<Todo>>() {
                @Override
                public void onResponse(Call<ArrayList<Todo>> call, Response<ArrayList<Todo>> response) {
                    todosRecyclerAdapter.updateTodos(response.body());
                }

                @Override
                public void onFailure(Call<ArrayList<Todo>> call, Throwable t) {

                }
            });
        }

    }
}
