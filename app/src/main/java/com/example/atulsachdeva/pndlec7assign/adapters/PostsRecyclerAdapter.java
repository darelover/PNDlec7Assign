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
import com.example.atulsachdeva.pndlec7assign.activities.CommentsActivity;
import com.example.atulsachdeva.pndlec7assign.models.Post;

import java.util.ArrayList;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class PostsRecyclerAdapter extends RecyclerView.Adapter<PostsRecyclerAdapter.PostViewHolder> {

    ArrayList<Post> posts = new ArrayList<>();
    Context context;

    public PostsRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updatePosts(ArrayList<Post> posts){
        this.posts = posts;
        notifyDataSetChanged();
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new PostViewHolder(li.inflate(R.layout.list_item_post,parent,false));
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        holder.bindView(posts.get(position));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserId, tvId, tvTitle, tvBody;
        Button btnComments;

        public PostViewHolder(View itemView) {
            super(itemView);

            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvId = itemView.findViewById(R.id.tvPostId);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvBody = itemView.findViewById(R.id.tvBody);
            btnComments = itemView.findViewById(R.id.btnComments);

        }

        public void bindView(final Post thisPost){
            tvUserId.setText(thisPost.getUserId());
            tvId.setText(thisPost.getId());
            tvTitle.setText(thisPost.getTitle());
            tvBody.setText(thisPost.getBody());

            btnComments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context,CommentsActivity.class);
                    i.putExtra("PostId",thisPost.getId());
                    i.putExtra("Title",thisPost.getTitle());
                    i.putExtra("Body",thisPost.getBody());
                    context.startActivity(i);
                }
            });
        }
    }
}
