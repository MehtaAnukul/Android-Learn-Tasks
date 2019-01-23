package com.anukul.notesrecycleviewtask.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.anukul.notesrecycleviewtask.R;
import com.anukul.notesrecycleviewtask.app.AppConstant;

public class InsertNotesDataActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = InsertNotesDataActivity.class.getSimpleName();
    private EditText titleEd;
    private EditText categoryEd;
    private EditText detailsEd;
    private Button insertBtn;

    private String title;
    private String category;
    private String details;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_notes_data);

        initView();

        intent = getIntent();
        changedBtnText();
    }

    private void changedBtnText() {
        final boolean status = intent.getBooleanExtra(AppConstant.KEY_CODE,true);
        if (status){
            insertBtn.setText("Update");
        }

    }

    private void initView() {
        titleEd = findViewById(R.id.activity_insert_NotesData_titleEd);
        categoryEd = findViewById(R.id.activity_insert_NotesData_categoryEd);
        detailsEd = findViewById(R.id.activity_insert_NotesData_detailsEd);

        insertBtn = findViewById(R.id.activity_insert_NotesData_insertBtn);
        insertBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        title = titleEd.getText().toString().trim();
        category = categoryEd.getText().toString().trim();
        details = detailsEd.getText().toString().trim();
        switch (v.getId()){
            case R.id.activity_insert_NotesData_insertBtn:
                addUpdateData();
                break;
        }

    }

    private void addUpdateData() {
        final boolean status = intent.getBooleanExtra(AppConstant.KEY_CODE,false);
        if (status){
           // intent.putExtra(AppConstant.KEY_CODE,true);
            int position = intent.getIntExtra(AppConstant.KEY_UPDATE_POSITION,200);
            Log.e(TAG,"addUpdateData : "+position);
        }
        intent.putExtra(AppConstant.KEY_title,title);
        intent.putExtra(AppConstant.KEY_category,category);
        intent.putExtra(AppConstant.KEY_dateils,details);

        setResult(RESULT_OK,intent);
        finish();
    }
}
