package com.anukul.profilerecycleview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProfileCustomAdapter extends RecyclerView.Adapter<ProfileCustomAdapter.ProfileCustomViewHolder> {

    private ArrayList<ProfileModel> profileModelArrayList;
    private ItemClickListener itemClickListener;


    public ProfileCustomAdapter(ArrayList<ProfileModel> profileModelArrayList, ItemClickListener itemClickListener) {
        this.profileModelArrayList = profileModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    public class ProfileCustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTv;
        TextView emailTv;
        ImageView profileImg;
        ProfileModel profileModel;

        public ProfileCustomViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.custom_layout_nameTv);
            emailTv = itemView.findViewById(R.id.custom_layout_emailTv);
            profileImg = itemView.findViewById(R.id.custom_layout_ImageView);
            itemView.setOnClickListener(this);
        }

        public void setData(ProfileModel data) {
            this.profileModel = data;

            nameTv.setText(data.getName());
            emailTv.setText(data.getEmail());
            profileImg.setImageResource(data.getImg());
        }

        @Override
        public void onClick(View v) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(profileModel);
            }

        }
    }

    @NonNull
    @Override
    public ProfileCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new ProfileCustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileCustomViewHolder holder, int position) {
        ProfileModel profileModel = profileModelArrayList.get(position);

        holder.setData(profileModel);

    }

    @Override
    public int getItemCount() {
        return profileModelArrayList.size();
    }


}
