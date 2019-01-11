package com.anukul.notesrecycleviewtask.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.anukul.notesrecycleviewtask.R;

public class MainActivity extends AppCompatActivity {
    private TextView notesTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesTv = findViewById(R.id.activity_main_noteTv);

        notesTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoNotesViewActivty = new Intent(MainActivity.this,NotesViewActivity.class);
                startActivity(gotoNotesViewActivty);
            }
        });
    }
}
