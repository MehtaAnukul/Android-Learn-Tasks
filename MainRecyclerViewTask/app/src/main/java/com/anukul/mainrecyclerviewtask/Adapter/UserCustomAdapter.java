package com.anukul.mainrecyclerviewtask.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anukul.mainrecyclerviewtask.Listener.ItemClickListener;
import com.anukul.mainrecyclerviewtask.R;
import com.anukul.mainrecyclerviewtask.Model.UserModel;

import java.util.ArrayList;

public class UserCustomAdapter extends RecyclerView.Adapter<UserCustomAdapter.UserCustomViewHolder>{

    private ArrayList<UserModel> userModelArrayList;
    private ItemClickListener itemClickListener;

    public UserCustomAdapter(ArrayList<UserModel> userModelArrayList, ItemClickListener itemClickListener) {
        this.userModelArrayList = userModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    public class UserCustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView nameTv;
        TextView dateTv;
        TextView detailsTv;
        ImageView userIconImageView;
        ImageView userContentImageView;
        ImageView customOptionMenu;

        UserModel userModel;

        public UserCustomViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.custom_layout_nameTv);
            dateTv = itemView.findViewById(R.id.custom_layout_dateTv);
            detailsTv = itemView.findViewById(R.id.custom_layout_detailsTv);
            userIconImageView = itemView.findViewById(R.id.custom_layout_userIconImageView);
            userContentImageView = itemView.findViewById(R.id.custom_layout_userContentImageView);

            customOptionMenu = itemView.findViewById(R.id.custom_layout_optionMenu);

            customOptionMenu.setOnClickListener(this);
            itemView.setOnClickListener(this);
        }

        public void setData(UserModel userModel){
            this.userModel = userModel;


            nameTv.setText(userModel.getNameTv());
            dateTv.setText(userModel.getDateTv());
            detailsTv.setText(userModel.getDetails());
            userIconImageView.setImageResource(userModel.getUserIconImg());
            userContentImageView.setImageResource(userModel.getUserContentImg());


        }

        @Override
        public void onClick(View v) {

            if(itemClickListener != null){
                itemClickListener.onItemClick(userModel,v);
            }
        }
    }
    @NonNull
    @Override
    public UserCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new UserCustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCustomViewHolder holder, int position) {

        UserModel userModel = userModelArrayList.get(position);

        holder.setData(userModel);
    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }


}
