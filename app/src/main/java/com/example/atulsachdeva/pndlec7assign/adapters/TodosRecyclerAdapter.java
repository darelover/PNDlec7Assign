package com.example.atulsachdeva.pndlec7assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.models.Todo;

import java.util.ArrayList;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class TodosRecyclerAdapter extends RecyclerView.Adapter<TodosRecyclerAdapter.TodoViewHolder> {

    ArrayList<Todo> todos = new ArrayList<>();
    Context context;

    public TodosRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updateTodos(ArrayList<Todo> todos) {
        this.todos = todos;
        notifyDataSetChanged();
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new TodoViewHolder(li.inflate(R.layout.list_item_todo, parent, false));
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.bindView(todos.get(position));
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }

    class TodoViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserId, tvId, tvTitle;
        CheckBox cbCompleted;

        public TodoViewHolder(View itemView) {
            super(itemView);

            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvId = itemView.findViewById(R.id.tvPostId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            cbCompleted = itemView.findViewById(R.id.cbCompleted);

        }
        public void bindView(Todo thisTodo) {
            tvUserId.setText(thisTodo.getUserId());
            tvId.setText(thisTodo.getId());
            tvTitle.setText(thisTodo.getTitle());
            if (thisTodo.getChecked())
                cbCompleted.setChecked(true);
            else
                cbCompleted.setChecked(false);
        }
    }
}
