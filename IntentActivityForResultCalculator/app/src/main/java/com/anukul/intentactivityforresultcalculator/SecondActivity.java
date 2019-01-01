package com.anukul.intentactivityforresultcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
    private int operationCode;
    private int ans;

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
        operationCode = intent.getIntExtra("KEY_CODE", 0);

        okBtn.setOnClickListener(this);
        cancelBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        value1 = Integer.parseInt(valueOneEd.getText().toString().trim());
        value2 = Integer.parseInt(valueSecEd.getText().toString().trim());

        switch (v.getId()) {
            case R.id.activity_second_okBtn:
                performTask();
                break;
        }

    }

    private void performTask() {
        switch (operationCode) {
            case 1:
                ans = value1 + value2;
                intent.putExtra("ADD", ans);
                intent.putExtra("KEY_CODE_RETURN_ADD", 1);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case 2:
                ans = value1 - value2;
                intent.putExtra("SUB", ans);
                intent.putExtra("KEY_CODE_RETURN_SUB", 2);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case 3:
                ans = value1 * value2;
                intent.putExtra("MUL", ans);
                intent.putExtra("KEY_CODE_RETURN_MUL", 3);
                setResult(RESULT_OK, intent);
                finish();
                break;
            case 4:
                ans = value1 / value2;
                intent.putExtra("DIV", ans);
                intent.putExtra("KEY_CODE_RETURN_DIV", 4);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }
}
