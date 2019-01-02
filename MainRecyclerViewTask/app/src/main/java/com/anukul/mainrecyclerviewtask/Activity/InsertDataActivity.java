package com.anukul.mainrecyclerviewtask.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.anukul.mainrecyclerviewtask.App.AppConstant;
import com.anukul.mainrecyclerviewtask.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertDataActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText nameEd;
    private TextView dateTv;
    private EditText detailsEd;
    private Button addBtn;

    private String nameData;
    private String detailsData;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertdata);

        initView();

    }

    private void initView() {
        nameEd = findViewById(R.id.activity_insertdata_nameEd);
        dateTv = findViewById(R.id.activity_insertdata_dateTv);
        detailsEd = findViewById(R.id.activity_insertdata_detailsEd);
        addBtn = findViewById(R.id.activity_insertdata_addBtn);

        intent = getIntent();

        dateTv.setOnClickListener(this);
        addBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        nameData = nameEd.getText().toString().trim();
        detailsData = detailsEd.getText().toString().trim();

        switch (v.getId()) {
            case R.id.activity_insertdata_dateTv:
                openDatePickerDialog();
                break;
            case R.id.activity_insertdata_addBtn:
                intent.putExtra(AppConstant.KEY_NAME, nameData);

                intent.putExtra("KEY_DETAILS", detailsData);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    private void openDatePickerDialog() {
        final String dateFormat;
        final Calendar calendar = Calendar.getInstance();

        final int mYear = calendar.get(Calendar.YEAR);
        final int mMonth = calendar.get(Calendar.MONTH);
        final int mDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTv.setText(month + " " +dayOfMonth + ","+year);
              //  DateFormat.getDateInstance().format(dateFormat);
            }
        }, mYear, mMonth, mDayOfMonth);
        datePickerDialog.show();
    }


}
