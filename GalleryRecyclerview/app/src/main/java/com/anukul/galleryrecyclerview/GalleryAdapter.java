package com.anukul.galleryrecyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>{

    private ArrayList<GalleryModel> galleryModelArrayList;
    private ItemClickListener itemClickListener;

    public GalleryAdapter(ArrayList<GalleryModel> galleryModelArrayList, ItemClickListener itemClickListener) {
        this.galleryModelArrayList = galleryModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    public class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView carName;
        ImageView carImgRes;
        GalleryModel galleryModel;

        public GalleryViewHolder(View itemView) {
            super(itemView);
            carName = itemView.findViewById(R.id.gallery_custom_layout_carName);
            carImgRes = itemView.findViewById(R.id.gallery_custom_layout_imgView);
            itemView.setOnClickListener(this);
        }


        public void setData(GalleryModel data) {
            this.galleryModel = data;

            carName.setText(galleryModel.getCarName());
            carImgRes.setImageResource(galleryModel.getImgRes());
        }

        @Override
        public void onClick(View v) {
            if(itemClickListener != null){
                itemClickListener.onItemClick(galleryModel);
            }
        }
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gallery_custom_layout,parent,false);

        return new GalleryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        GalleryModel galleryModel = galleryModelArrayList.get(position);

        holder.setData(galleryModel);
    }

    @Override
    public int getItemCount() {
        return galleryModelArrayList.size();
    }


}
