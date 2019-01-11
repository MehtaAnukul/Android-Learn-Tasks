package com.anukul.notesrecycleviewtask.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.anukul.notesrecycleviewtask.R;
import com.anukul.notesrecycleviewtask.listener.ItemClickListener;
import com.anukul.notesrecycleviewtask.model.NotesModel;

import java.util.ArrayList;

public class NotesCustomAdapter extends RecyclerView.Adapter<NotesCustomAdapter.NotesCustomViewHolder> {

    private ArrayList<NotesModel> notesModelArrayList;
    private ItemClickListener itemClickListener;

    public NotesCustomAdapter(ArrayList<NotesModel> notesModelArrayList, ItemClickListener itemClickListener) {
        this.notesModelArrayList = notesModelArrayList;
        this.itemClickListener = itemClickListener;
    }

    public class NotesCustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView titleTv;
        TextView categoryTv;
        TextView detailsTv;
        ImageView notesCustomMenu;


        NotesModel notesModel;
        int position;

        public NotesCustomViewHolder(View itemView) {
            super(itemView);

            titleTv = itemView.findViewById(R.id.notes_custom_layout_titleTv);
            categoryTv = itemView.findViewById(R.id.notes_custom_layout_categoryTv);
            detailsTv = itemView.findViewById(R.id.notes_custom_layout_detailsTv);

            notesCustomMenu = itemView.findViewById(R.id.notes_custom_layout_optionMenu);

            itemView.setOnClickListener(this);
        }

        public void setData(NotesModel notesModel, int position) {
            this.notesModel = notesModel;
            this.position = position;

            titleTv.setText(notesModel.getTitle());
            categoryTv.setText(notesModel.getCategory());
            detailsTv.setText(notesModel.getDetails());
        }

        @Override
        public void onClick(View view) {
            if (itemClickListener != null) {
                itemClickListener.onItemClick(notesModel, view, position);
            }
        }
    }

    @NonNull
    @Override
    public NotesCustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_custom_layout, parent, false);
        return new NotesCustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesCustomViewHolder holder, int position) {

        NotesModel notesModel = notesModelArrayList.get(position);

        holder.setData(notesModel, position);
    }

    @Override
    public int getItemCount() {
        return notesModelArrayList.size();
    }


}
