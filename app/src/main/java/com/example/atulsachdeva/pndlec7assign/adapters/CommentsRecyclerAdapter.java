package com.example.atulsachdeva.pndlec7assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.models.Comment;

import java.util.ArrayList;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class CommentsRecyclerAdapter extends RecyclerView.Adapter<CommentsRecyclerAdapter.CommentViewHolder> {

    ArrayList<Comment> comments = new ArrayList<>();
    Context context;

    public CommentsRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updateComments(ArrayList<Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @Override
    public CommentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new CommentViewHolder(li.inflate(R.layout.list_item_comments, parent, false));
    }

    @Override
    public void onBindViewHolder(CommentViewHolder holder, int position) {
        holder.bindView(comments.get(position));
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvName, tvEmail, tvBody;

        public CommentViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvPostId);
            tvName = itemView.findViewById(R.id.tvName);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            tvBody = itemView.findViewById(R.id.tvBody);
        }

        public void bindView(Comment thisComment) {
            tvId.setText(thisComment.getId());
            tvName.setText(thisComment.getName());
            tvEmail.setText(thisComment.getEmail());
            tvBody.setText(thisComment.getBody());
        }
    }
}
