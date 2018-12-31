package com.anukul.travelstreamcardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class TravelBeacheAdapter extends RecyclerView.Adapter<TravelBeacheAdapter.TravalBeacheViewHolder> {

    private ArrayList<TravelBeacheModel> travelBeacheModelArrayList;

    public TravelBeacheAdapter(ArrayList<TravelBeacheModel> travelBeacheModelArrayList) {
        this.travelBeacheModelArrayList = travelBeacheModelArrayList;
    }

    public class TravalBeacheViewHolder extends RecyclerView.ViewHolder {
        TextView topBeacheTv;
        TextView numberTv;
        TextView beacheNameTv;
        TextView beacheLocation;

        public TravalBeacheViewHolder(View itemView) {
            super(itemView);

            topBeacheTv = itemView.findViewById(R.id.custom_layout_topBeacheTv);
            numberTv = itemView.findViewById(R.id.custom_layout_numberTv);
            beacheNameTv = itemView.findViewById(R.id.custom_layout_beacheNameTv);
            beacheLocation = itemView.findViewById(R.id.custom_layout_beacheLocationTv);
        }
    }

    @NonNull
    @Override
    public TravalBeacheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new TravalBeacheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TravalBeacheViewHolder holder, int position) {
        TravelBeacheModel travelBeacheModel = travelBeacheModelArrayList.get(position);

        holder.topBeacheTv.setText(travelBeacheModel.getTopBeache());
        holder.numberTv.setText(travelBeacheModel.getNumber());
        holder.beacheNameTv.setText(travelBeacheModel.getNameOfBeache());
        holder.beacheLocation.setText(travelBeacheModel.getBeacheLocation());
    }

    @Override
    public int getItemCount() {
        return travelBeacheModelArrayList.size();
    }


}
