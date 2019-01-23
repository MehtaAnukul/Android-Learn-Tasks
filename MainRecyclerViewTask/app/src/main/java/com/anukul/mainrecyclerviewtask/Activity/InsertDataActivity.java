package com.anukul.mainrecyclerviewtask.Activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.anukul.mainrecyclerviewtask.App.AppConstant;
import com.anukul.mainrecyclerviewtask.R;

import java.util.Calendar;

public class InsertDataActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = InsertDataActivity.class.getSimpleName();
    private EditText nameEd;
    private TextView dateTv;
    private EditText detailsEd;
    private Button insertBtn;

    private String nameData;
    private String dateData;
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
        insertBtn = findViewById(R.id.activity_insertdata_insertBtn);

        intent = getIntent();
        changedBtnText();

        dateTv.setOnClickListener(this);
        insertBtn.setOnClickListener(this);
    }

    private void changedBtnText() {
        final Boolean status = intent.getBooleanExtra(AppConstant.KEY_CODE, true);
        if (status) {
            insertBtn.setText("Update");
        }

    }

    @Override
    public void onClick(View v) {
        nameData = nameEd.getText().toString().trim();
        dateData = dateTv.getText().toString().trim();
        detailsData = detailsEd.getText().toString().trim();

        switch (v.getId()) {
            case R.id.activity_insertdata_dateTv:
                openDatePickerDialog();
                break;
            case R.id.activity_insertdata_insertBtn:
                addUpdateData();
                break;
        }
    }

    private void addUpdateData() {


        final boolean status = intent.getBooleanExtra(AppConstant.KEY_CODE, false);

        if (status) {

//            intent.putExtra(AppConstant.KEY_CODE, true);
            int position = intent.getIntExtra(AppConstant.KEY_UPDATE_POSITION, 200);

            Log.e(TAG, "addUpdateData: "  + position);

//            intent.putExtra(AppConstant.KEY_UPDATE_POSITION, position);

        }

        intent.putExtra(AppConstant.KEY_NAME, nameData);
        intent.putExtra(AppConstant.KEY_DATE, dateData);
        intent.putExtra(AppConstant.KEY_DETAILS, detailsData);

        setResult(RESULT_OK, intent);
        finish();

    }

    private void openDatePickerDialog() {
        // final String dateFormat;
        final Calendar calendar = Calendar.getInstance();

        final int mYear = calendar.get(Calendar.YEAR);
        final int mMonth = calendar.get(Calendar.MONTH);
        final int mDayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        final String[] monthName = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                dateTv.setText(monthName[month + 1] + " " + dayOfMonth + "," + year);
                //  DateFormat.getDateInstance().format(dateFormat);
            }
        }, mYear, mMonth, mDayOfMonth);
        datePickerDialog.show();
    }


}
