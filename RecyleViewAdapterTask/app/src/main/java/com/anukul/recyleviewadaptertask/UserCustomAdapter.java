package com.anukul.recyleviewadaptertask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserCustomAdapter extends RecyclerView.Adapter<UserCustomAdapter.UserCustomViewHolder>  {
   private ArrayList<UserModel> userCustomModelArrayList;

    public UserCustomAdapter(ArrayList<UserModel> userCustomModelArrayList) {
        this.userCustomModelArrayList = userCustomModelArrayList;
    }

    public class UserCustomViewHolder extends RecyclerView.ViewHolder {
        TextView userNameTv;
        public UserCustomViewHolder(View itemView) {
            super(itemView);

            userNameTv = itemView.findViewById(R.id.custom_layout_nameTv);
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
        UserModel userModel = userCustomModelArrayList.get(position);

        holder.userNameTv.setText(userModel.getName());
    }

    @Override
    public int getItemCount() {
        return userCustomModelArrayList.size();
    }


}
