package com.example.atulsachdeva.pndlec7assign.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.activities.AlbumsActivity;
import com.example.atulsachdeva.pndlec7assign.activities.PostsActivity;
import com.example.atulsachdeva.pndlec7assign.activities.TodosActivity;
import com.example.atulsachdeva.pndlec7assign.models.User;

import java.util.ArrayList;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class UsersRecyclerAdapter extends RecyclerView.Adapter<UsersRecyclerAdapter.UserViewHolder> {

    ArrayList<User> users = new ArrayList<>();
    Context context;

    public UsersRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updateUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new UserViewHolder(li.inflate(R.layout.list_item_user, parent, false));
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.bindView(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvUserName, tvEmail;
        TextView tvCity, tvZipcode;
        Button btnPosts, btnAlbums, btnTodos;

        public UserViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvPostId);
            tvName = itemView.findViewById(R.id.tvName);
            tvUserName = itemView.findViewById(R.id.tvUserName);
            tvEmail = itemView.findViewById(R.id.tvEmail);

            tvCity = itemView.findViewById(R.id.tvCity);
            tvZipcode = itemView.findViewById(R.id.tvZipcode);


            btnPosts = itemView.findViewById(R.id.btnPosts);
            btnAlbums = itemView.findViewById(R.id.btnAlbums);
            btnTodos = itemView.findViewById(R.id.btnTodos);
        }

        public void bindView(final User thisUser){
            tvId.setText(thisUser.getId());
            tvName.setText(thisUser.getName());
            tvUserName.setText(thisUser.getUsername());
            tvEmail.setText(thisUser.getEmail());


            tvCity.setText(thisUser.getAddress().getCity());
            tvZipcode.setText(thisUser.getAddress().getZipcode());


            btnPosts.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PostsActivity.class);
                    i.putExtra("UserId",thisUser.getId());
                    context.startActivity(i);
                }
            });
            btnAlbums.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, AlbumsActivity.class);
                    i.putExtra("UserId",thisUser.getId());
                    context.startActivity(i);
                }
            });
            btnTodos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, TodosActivity.class);
                    i.putExtra("UserId",thisUser.getId());
                    context.startActivity(i);
                }
            });

        }
    }
}
