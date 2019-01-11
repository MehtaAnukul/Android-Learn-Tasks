package com.anukul.notesrecycleviewtask.listener;

import android.view.View;

import com.anukul.notesrecycleviewtask.model.NotesModel;

public interface ItemClickListener {
    public void onItemClick(NotesModel notesModel, View view ,int position);
}