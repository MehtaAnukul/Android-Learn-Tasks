package com.anukul.carcardview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CarCustomAdapter extends RecyclerView.Adapter<CarCustomAdapter.CarCustomViewHolder> {

    private ArrayList<CarCustomModel> carCustomModelArrayList;

    public CarCustomAdapter(ArrayList<CarCustomModel> carCustomModelArrayList) {
        this.carCustomModelArrayList = carCustomModelArrayList;
    }

    public class CarCustomViewHolder extends RecyclerView.ViewHolder {
        TextView carNameTv;
        TextView carPrice;

        public CarCustomViewHolder(View itemView) {
            super(itemView);
            carNameTv = itemView.findViewById(R.id.custom_layout_carNameTv);
            carPrice = itemView.findViewById(R.id.custom_layout_carPriceTv);
        }
    }

    @NonNull
    @Override
    public CarCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout, parent, false);
        return new CarCustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarCustomViewHolder holder, int position) {
        CarCustomModel carCustomModel = carCustomModelArrayList.get(position);
        holder.carNameTv.setText(carCustomModel.getCarName());
        holder.carPrice.setText(carCustomModel.getCarPrice());
    }

    @Override
    public int getItemCount() {
        return carCustomModelArrayList.size();
    }

}
