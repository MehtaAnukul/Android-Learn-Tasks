package com.anukul.calculatorintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class calulatorminiAnswerActivity extends AppCompatActivity {

    private int result;
    private TextView answerTv;
    private Intent intent;

    private int intentvalueOne;
    private int intentvalueSec;
    private int intentOperator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_answer);

        initView();

        intent = getIntent();
        intentvalueOne = intent.getIntExtra("KEY_VALUEONE", 1);
        intentvalueSec = intent.getIntExtra("KEY_VALUESEC", 1);
        intentOperator = intent.getIntExtra("KEY_OPERATOR", 10);

        calculation(intentOperator);
    }
    private void calculation(int intentOperator) {
        switch (intentOperator) {
            case 1:
                result = intentvalueOne + intentvalueSec;
                answerTv.setText(result + "");
                break;
            case 2:
                result = intentvalueOne - intentvalueSec;
                answerTv.setText(result + "");
                break;
            case 3:
                result = intentvalueOne * intentvalueSec;
                answerTv.setText(result + "");
                break;
            case 4:
                result = intentvalueOne / intentvalueSec;
                answerTv.setText(result + "");
                break;
        }
    }
    private void initView() {
        answerTv = findViewById(R.id.activity_calculatorAnswer_answerTv);
    }
}
