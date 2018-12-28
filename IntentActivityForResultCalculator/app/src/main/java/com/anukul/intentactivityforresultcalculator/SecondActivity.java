package com.anukul.intentactivityforresultcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText valueOneEd;
    private EditText valueSecEd;
    private Button okBtn;
    private Button cancelBtn;
    private int value1;
    private int value2;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    private void initView() {
        valueOneEd = findViewById(R.id.activity_second_valueOneEd);
        valueSecEd = findViewById(R.id.activity_second_valueSecEd);
        okBtn = findViewById(R.id.activity_second_okBtn);
        cancelBtn = findViewById(R.id.activity_second_cencalBtn);

        intent = getIntent();

        okBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        value1 = Integer.parseInt(valueOneEd.getText().toString().trim());
        value2 = Integer.parseInt(valueSecEd.getText().toString().trim());

        switch (v.getId()){

            case R.id.activity_second_okBtn:
                intent.putExtra("ADD",value1 + value2);
                setResult(RESULT_OK,intent);
                finish();
            case 2:
                intent.putExtra("SUB",value1 - value2);
                setResult(RESULT_OK,intent);
                finish();
            case 3:
                intent.putExtra("MUL",value1 * value2);
                setResult(RESULT_OK,intent);
                finish();
            case 4:
                intent.putExtra("MUL",value1 * value2);
                setResult(RESULT_OK,intent);
                finish();
        }

    }
}
