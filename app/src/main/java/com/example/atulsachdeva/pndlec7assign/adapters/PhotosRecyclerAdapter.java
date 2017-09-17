package com.example.atulsachdeva.pndlec7assign.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.atulsachdeva.pndlec7assign.R;
import com.example.atulsachdeva.pndlec7assign.models.Photo;

import java.util.ArrayList;

/**
 * Created by AtulSachdeva on 14/09/17.
 */

public class PhotosRecyclerAdapter extends RecyclerView.Adapter<PhotosRecyclerAdapter.PhotoViewHolder> {

    ArrayList<Photo> photos = new ArrayList<>();
    Context context;

    public PhotosRecyclerAdapter(Context context) {
        this.context = context;
    }

    public void updatePhotos(ArrayList<Photo> photos) {
        this.photos = photos;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        return new PhotoViewHolder(li.inflate(R.layout.list_item_photo, parent, false));
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bindView(photos.get(position));
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {

        TextView tvId, tvTitle;
        ImageView ivImage;

        public PhotoViewHolder(View itemView) {
            super(itemView);

            tvId = itemView.findViewById(R.id.tvPostId);
            tvTitle = itemView.findViewById(R.id.tvTitle);

            ivImage = itemView.findViewById(R.id.ivImage);
        }

        public void bindView(Photo thisPhoto) {
            tvId.setText(thisPhoto.getId());
            tvTitle.setText(thisPhoto.getTite());

            // have to dwnld image and set it to ivImage
            // should i dwnld images in background or onthis same thread

//            try {
//                URL url = new URL(thisPhoto.getUrl());
//
//                Bitmap bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
//                ivImage.setImageBitmap(bitmap);
//
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
}
