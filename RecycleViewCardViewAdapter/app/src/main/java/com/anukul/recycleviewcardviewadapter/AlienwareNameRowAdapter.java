package com.anukul.recycleviewcardviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AlienwareNameRowAdapter extends RecyclerView.Adapter<AlienwareNameRowAdapter.AlienwareViewHolder> {

    private ArrayList<AlienwareModel> alienwareModelArrayList;

    public AlienwareNameRowAdapter(ArrayList<AlienwareModel> alienwareModelArrayList) {
        this.alienwareModelArrayList = alienwareModelArrayList;
    }

    public class AlienwareViewHolder extends RecyclerView.ViewHolder {
        TextView alienwareNameTv;

        public AlienwareViewHolder(View itemView) {
            super(itemView);

            alienwareNameTv = itemView.findViewById(R.id.row_layout_alienwareTv);
        }
    }

    @NonNull
    @Override
    public AlienwareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new AlienwareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlienwareViewHolder holder, int position) {

        AlienwareModel alienwareModel = alienwareModelArrayList.get(position);

        holder.alienwareNameTv.setText(alienwareModel.getAlienwareName());
    }

    @Override
    public int getItemCount() {
        return alienwareModelArrayList.size();
    }


}
