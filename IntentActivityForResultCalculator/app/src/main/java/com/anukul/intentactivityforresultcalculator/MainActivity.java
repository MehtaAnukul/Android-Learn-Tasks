package com.anukul.intentactivityforresultcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button sumBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;
    private TextView answerTv;

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

        sumBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_sumBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(gotoSecondActivityIntent,1);
                break;
            case R.id.activity_main_subBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(gotoSecondActivityIntent,2);
                break;
            case R.id.activity_main_mulBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(gotoSecondActivityIntent,3);
                break;
            case R.id.activity_main_divBtn:
                gotoSecondActivityIntent = new Intent(MainActivity.this,SecondActivity.class);
                startActivityForResult(gotoSecondActivityIntent,4);
                break;
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                if(data != null){
                    final int result = data.getIntExtra("ADD",10);
                    answerTv.setText(result+"");
                }
            }
        }
    }
}
