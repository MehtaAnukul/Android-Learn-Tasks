package com.anukul.recyleviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder>
{
   private ArrayList<UserModel> userModelArrayList;

    public UserAdapter(ArrayList<UserModel> userModelArrayList) {
        this.userModelArrayList = userModelArrayList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
         TextView userNameTv;
         TextView userEmailTv;
         TextView userTimeTv;

        public MyViewHolder(View itemView) {
            super(itemView);

            userNameTv = itemView.findViewById(R.id.row_layout_nameTv);
            userEmailTv = itemView.findViewById(R.id.row_layout_emailTv);
            userTimeTv = itemView.findViewById(R.id.row_layout_timeTv);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new MyViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        UserModel userModel = userModelArrayList.get(position);

        holder.userNameTv.setText(userModel.getName());
        holder.userEmailTv.setText(userModel.getEmail());
        holder.userTimeTv.setText(userModel.getTime());

    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }






}
