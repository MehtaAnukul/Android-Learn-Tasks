package com.anukul.calculatormini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculatorminiActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText value1Ed;
    private TextView operatorTv;
    private EditText value2Ed;
    private TextView answerTv;

    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculatormini);

        initview();
    }

    private void initview() {
        //binding compo
        value1Ed = findViewById(R.id.activity_calculatormini_value1_ed);
        operatorTv = findViewById(R.id.activity_calculatormini_operator_tv);
        value2Ed = findViewById(R.id.activity_calculatormini_value2_ed);

        answerTv = findViewById(R.id.activity_calculatormini_answer_tv);

        addBtn = findViewById(R.id.activity_calculatormini_addbtn);
        subBtn = findViewById(R.id.activity_calculatormini_subbtn);
        mulBtn = findViewById(R.id.activity_calculatormini_mulbtn);
        divBtn = findViewById(R.id.activity_calculatormini_divbtn);


        //init listener
        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final int myvalue1 = Integer.parseInt(value1Ed.getText().toString().trim());
        final int myvalue2 = Integer.parseInt(value2Ed.getText().toString().trim());

        float result;

        switch (v.getId()) {
            case R.id.activity_calculatormini_addbtn:
                result = myvalue1 + myvalue2;
                operatorTv.setText(addBtn.getText().toString());
                answerTv.setText(result + "");
                break;
            case R.id.activity_calculatormini_subbtn:
                result = myvalue1 - myvalue2;
                operatorTv.setText(subBtn.getText().toString());
                answerTv.setText(String.valueOf(result));
                break;
            case R.id.activity_calculatormini_mulbtn:
                result = myvalue1 * myvalue2;
                operatorTv.setText(mulBtn.getText().toString());
                answerTv.setText(String.valueOf(result));
                break;
            case R.id.activity_calculatormini_divbtn:
                result = myvalue1 / myvalue2;
                operatorTv.setText(divBtn.getText().toString());
                answerTv.setText(String.valueOf(result));
                break;
        }

    }
}
