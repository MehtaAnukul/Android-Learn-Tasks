package com.anukul.intentactivityforresultcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button sumBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private TextView answerTv;
    private int result;
    private int returnCode;

    private Intent gotoSecondActivityIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        sumBtn = findViewById(R.id.activity_main_sumBtn);
        subBtn = findViewById(R.id.activity_main_subBtn);
        mulBtn = findViewById(R.id.activity_main_mulBtn);
        divBtn = findViewById(R.id.activity_main_divBtn);
        answerTv = findViewById(R.id.activity_main_answerTv);

        sumBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_sumBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                gotoSecondActivityIntent.putExtra("KEY_CODE", 1);
                startActivityForResult(gotoSecondActivityIntent, 100);
                break;
            case R.id.activity_main_subBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                gotoSecondActivityIntent.putExtra("KEY_CODE", 2);
                startActivityForResult(gotoSecondActivityIntent, 200);
                break;
            case R.id.activity_main_mulBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                gotoSecondActivityIntent.putExtra("KEY_CODE", 3);
                startActivityForResult(gotoSecondActivityIntent, 300);
                break;
            case R.id.activity_main_divBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this, SecondActivity.class);
                gotoSecondActivityIntent.putExtra("KEY_CODE", 4);
                startActivityForResult(gotoSecondActivityIntent, 400);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    returnCode = data.getIntExtra("KEY_CODE_RETURN_ADD", 0);
                    Log.e(TAG, "onActivityResult: " + returnCode);
                    displayOutPut(returnCode, data);
                }
            }
        } else if (requestCode == 200) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    resultCode = data.getIntExtra("KEY_CODE_RETURN_SUB", 0);
                    displayOutPut(resultCode, data);
                }
            }
        } else if (requestCode == 300) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    resultCode = data.getIntExtra("KEY_CODE_RETURN_MUL", 0);
                    displayOutPut(resultCode, data);
                }
            }
        } else if (requestCode == 400) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    resultCode = data.getIntExtra("KEY_CODE_RETURN_DIV", 0);
                    displayOutPut(resultCode, data);
                }
            }
        }
    }


    private void displayOutPut(int returnCode, Intent data) {
        switch (returnCode) {

            case 1:
                result = data.getIntExtra("ADD", 0);
                answerTv.setText(result + "");
                break;
            case 2:
                result = data.getIntExtra("SUB", 0);
                answerTv.setText(result + "");
                break;
            case 3:
                result = data.getIntExtra("MUL", 0);
                answerTv.setText(result + "");
                break;
            case 4:
                result = data.getIntExtra("DIV", 0);
                answerTv.setText(result + "");
                break;
        }
    }
}
