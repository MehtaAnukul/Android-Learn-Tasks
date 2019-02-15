package com.example.hitmer.officeexamapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ListViewHolder> {
    Context context;
    List<Contact> mContactList;

    public RecyclerAdapter(Context context, List<Contact> mContactList) {
        this.context = context;
        this.mContactList = mContactList;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_layout,viewGroup,false);
        return new ListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder listViewHolder, int i) {
        Contact mCurrentList = mContactList.get(i);
        listViewHolder.tvId.setText(mCurrentList.getId());
        listViewHolder.tvFirstName.setText(mCurrentList.getFirstName());
        listViewHolder.tvLastName.setText(mCurrentList.getLastName());
        listViewHolder.tvPhoneNo.setText(mCurrentList.getPhoneNumber());
        listViewHolder.tvEmail.setText(mCurrentList.getEmail());
    }

    @Override
    public int getItemCount() {
        return mContactList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvId,tvFirstName,tvLastName,tvPhoneNo,tvEmail;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.txt_id);
            tvFirstName = itemView.findViewById(R.id.txt_firstName);
            tvLastName = itemView.findViewById(R.id.txt_lastName);
            tvPhoneNo = itemView.findViewById(R.id.txt_phoneNo);
            tvEmail = itemView.findViewById(R.id.txt_emailid);

        }
    }
}
