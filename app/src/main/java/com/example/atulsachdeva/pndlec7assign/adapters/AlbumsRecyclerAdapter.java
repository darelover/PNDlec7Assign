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
import com.example.atulsachdeva.pndlec7assign.activities.PhotosActivity;
import com.example.atulsachdeva.pndlec7assign.models.Album;

import java.util.ArrayList;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class AlbumsRecyclerAdapter extends RecyclerView.Adapter<AlbumsRecyclerAdapter.AlbumViewHolder> {

    ArrayList<Album> albums = new ArrayList<>();
    Context context;

    public AlbumsRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updateAlbums(ArrayList<Album> albums){
        this.albums = albums;
        notifyDataSetChanged();
    }

    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new AlbumViewHolder(li.inflate(R.layout.list_item_album, parent, false));
    }

    @Override
    public void onBindViewHolder(AlbumViewHolder holder, int position) {
        holder.bindView(albums.get(position));
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    class AlbumViewHolder extends RecyclerView.ViewHolder {

        TextView tvUserId, tvId, tvTitle;
        Button btnPhotos;

        public AlbumViewHolder(View itemView) {
            super(itemView);

            tvUserId = itemView.findViewById(R.id.tvUserId);
            tvId = itemView.findViewById(R.id.tvPostId);
            tvTitle = itemView.findViewById(R.id.tvTitle);


            btnPhotos = itemView.findViewById(R.id.btnPhotos);

        }

        public void bindView(final Album thisAlbum){
            tvUserId.setText(thisAlbum.getUserId());
            tvId.setText(thisAlbum.getId());
            tvTitle.setText(thisAlbum.getTitle());

            btnPhotos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(context, PhotosActivity.class);
                    i.putExtra("AlbumId",thisAlbum.getId());
                    i.putExtra("Title",thisAlbum.getTitle());
                    context.startActivity(i);
                }
            });
        }
    }
}
