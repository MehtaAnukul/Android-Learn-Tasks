package com.anukul.recyleviewadaptertask;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder>  {

    private ArrayList<UserModel> userModelArrayList;

    public UserAdapter(ArrayList<UserModel> userModelArrayList) {
        this.userModelArrayList = userModelArrayList;
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;

        public UserViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.row_layout_nameTv);


        }
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }


}
