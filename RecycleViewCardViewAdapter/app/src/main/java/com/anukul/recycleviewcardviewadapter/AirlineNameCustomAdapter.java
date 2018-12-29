package com.anukul.recycleviewcardviewadapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AirlineNameCustomAdapter extends RecyclerView.Adapter<AirlineNameCustomAdapter.AirlineViewHolder> {

    private ArrayList<AirlineModel> airlineModelArrayList;

    public AirlineNameCustomAdapter(ArrayList<AirlineModel> airlineModelArrayList) {
        this.airlineModelArrayList = airlineModelArrayList;
    }

    public class AirlineViewHolder extends RecyclerView.ViewHolder {

        TextView airlineNameTv;

        public AirlineViewHolder(View itemView) {
            super(itemView);

            airlineNameTv = itemView.findViewById(R.id.custom_layout_airlineNameTv);

        }
    }

    @NonNull
    @Override
    public AirlineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new AirlineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AirlineViewHolder holder, int position) {
        AirlineModel airlineModel = airlineModelArrayList.get(position);

        holder.airlineNameTv.setText(airlineModel.getAitlineName());

    }

    @Override
    public int getItemCount() {
        return airlineModelArrayList.size();
    }


}
