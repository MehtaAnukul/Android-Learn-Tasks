package com.anukul.carcardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RowAdapter extends RecyclerView.Adapter<RowAdapter.RowViewHolder>{

    private ArrayList<RowModel> rowModelArrayList;

    public RowAdapter(ArrayList<RowModel> rowModelArrayList) {
        this.rowModelArrayList = rowModelArrayList;
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        TextView welcomeTv;
        public RowViewHolder(View itemView) {
            super(itemView);

            welcomeTv = itemView.findViewById(R.id.row_layout_welcomeTv);
        }
    }

    @NonNull
    @Override
    public RowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout,parent,false);
        return new RowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowViewHolder holder, int position) {
        RowModel rowModel = rowModelArrayList.get(position);

        holder.welcomeTv.setText(rowModel.getWelcomeTv());
    }

    @Override
    public int getItemCount() {
        return rowModelArrayList.size();
    }


}
