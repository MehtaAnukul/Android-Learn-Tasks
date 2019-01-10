package com.anukul.notesrecycleviewtask.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.anukul.notesrecycleviewtask.Model.NotesModel;
import com.anukul.notesrecycleviewtask.R;
import com.anukul.notesrecycleviewtask.listener.ItemClickListener;

import java.util.ArrayList;

public class NotesCustomAdapter extends RecyclerView.Adapter<NotesCustomAdapter.NotesCustomViewHolder> {

    private ItemClickListener itemClickListener;
    private ArrayList<NotesModel> notesModelArrayList;

    public NotesCustomAdapter(ItemClickListener itemClickListener, ArrayList<NotesModel> notesModelArrayList) {
        this.itemClickListener = itemClickListener;
        this.notesModelArrayList = notesModelArrayList;
    }

    public class NotesCustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        EditText titleEd;
        EditText categoryEd;
        EditText detailsEd;
        ImageView notesCustomMenu;

        NotesModel notesModel;
        int position;

        public NotesCustomViewHolder(View itemView) {
            super(itemView);

            titleEd = itemView.findViewById(R.id.activity_insert_NotesData_titleEd);
            categoryEd = itemView.findViewById(R.id.activity_insert_NotesData_categoryEd);
            detailsEd = itemView.findViewById(R.id.activity_insert_NotesData_detailsEd);

            notesCustomMenu = itemView.findViewById(R.id.notes_custom_layout_optionMenu);

            itemView.setOnClickListener(this);
        }

        public void setData(NotesModel notesModel, int position) {
            this.notesModel = notesModel;
            this.position = position;

            titleEd.setText(notesModel.getTitle());
            categoryEd.setText(notesModel.getCategory());
            detailsEd.setText(notesModel.getDeteils());
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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_notes_view, parent, false);
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
