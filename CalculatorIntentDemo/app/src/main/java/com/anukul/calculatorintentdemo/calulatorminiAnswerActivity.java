package com.anukul.calculatorintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class calulatorminiAnswerActivity extends AppCompatActivity {

    private TextView answerTv;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_answer);

        initView();

        intent = getIntent();

        int instentAnswer = intent.getIntExtra("KEY_ANSWER",10);
        answerTv.setText(instentAnswer+"");

    }

    private void initView() {
        answerTv = findViewById(R.id.activity_calculatorAnswer_answerTv);

    }
}
