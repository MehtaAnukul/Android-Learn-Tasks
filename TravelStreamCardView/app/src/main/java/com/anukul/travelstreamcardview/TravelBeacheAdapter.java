package com.anukul.travelstreamcardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TravelBeacheAdapter extends RecyclerView.Adapter<TravelBeacheAdapter.TravalBeacheViewHolder> {

    private ArrayList<TravelBeacheModel> travelBeacheModelArrayList;
    private ItemClickListener itemClickListener;

    public TravelBeacheAdapter(ArrayList<TravelBeacheModel> travelBeacheModelArrayList, ItemClickListener itemClickListener) {
        this.travelBeacheModelArrayList = travelBeacheModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    public class TravalBeacheViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView topBeacheTv;
        TextView numberTv;
        TextView beacheNameTv;
        TextView beacheLocation;
        ImageView beacheImg;
        TravelBeacheModel travelBeacheModel;

        public TravalBeacheViewHolder(View itemView) {
            super(itemView);

            topBeacheTv = itemView.findViewById(R.id.custom_layout_topBeacheTv);
            numberTv = itemView.findViewById(R.id.custom_layout_numberTv);
            beacheNameTv = itemView.findViewById(R.id.custom_layout_beacheNameTv);
            beacheLocation = itemView.findViewById(R.id.custom_layout_beacheLocationTv);
            beacheImg = itemView.findViewById(R.id.custom_layout_beachImg);
            itemView.setOnClickListener(this);
        }

        public void setData(TravelBeacheModel data) {
            this.travelBeacheModel = data;

            topBeacheTv.setText(data.getTopBeache());
            numberTv.setText(data.getNumber());
            beacheNameTv.setText(data.getNameOfBeache());
            beacheLocation.setText(data.getBeacheLocation());
            beacheImg.setImageResource(data.getTravelBeacheImages());

        }
        @Override
        public void onClick(View v) {
            if (itemClickListener != null){
                itemClickListener.onItemClick(travelBeacheModel);
            }
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

        holder.setData(travelBeacheModel);

    }

    @Override
    public int getItemCount() {
        return travelBeacheModelArrayList.size();
    }


}
