package com.anukul.calculatorintentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class calculatorminiiActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText valueOneEd;
    private TextView opreatorTv;
    private EditText valueSecondEd;

    private Button addBtn;
    private Button subBtn;
    private Button mulBtn;
    private Button divBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calulatorminii);

        initView();
    }

    private void initView() {

        valueOneEd = findViewById(R.id.activity_calculatormini_valueOneEd);
        valueSecondEd = findViewById(R.id.activity_calculatormini_valueSecondTv);
        opreatorTv = findViewById(R.id.activity_calculatormini_operatorTv);

        addBtn = findViewById(R.id.activity_calculatormini_addBtn);
        subBtn = findViewById(R.id.activity_calculatormini_subBtn);
        mulBtn = findViewById(R.id.activity_calculatormini_mulBtn);
        divBtn = findViewById(R.id.activity_calculatormini_divBtn);

        addBtn.setOnClickListener(this);
        subBtn.setOnClickListener(this);
        mulBtn.setOnClickListener(this);
        divBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {


        final int value1 = Integer.parseInt(valueOneEd.getText().toString().trim());
        final int value2 = Integer.parseInt(valueSecondEd.getText().toString().trim());


        switch (v.getId()){
            case R.id.activity_calculatormini_addBtn:
                //result = value1 + value2;
              opreatorTv.setText(addBtn.getText().toString());
                gotoSecondActivity(value1,value2,1);
                break;
            case R.id.activity_calculatormini_subBtn:
                //result = value1 - value2;
                opreatorTv.setText(subBtn.getText().toString());
                gotoSecondActivity(value1,value2,2);
                break;
            case R.id.activity_calculatormini_mulBtn:
                //result = value1 * value2;
                opreatorTv.setText(mulBtn.getText().toString());
                gotoSecondActivity(value1,value2,3);
                break;
            case R.id.activity_calculatormini_divBtn:
                //result = value1 / value2;
                opreatorTv.setText(divBtn.getText().toString());
                gotoSecondActivity(value1,value2,4);
                break;
        }
    }

    private void gotoSecondActivity(int value1,int value2,int operatorCode) {
        final Intent gotosecondActivity = new Intent(calculatorminiiActivity.this,calulatorminiAnswerActivity.class);
       // gotosecondActivity.putExtra("KEY_ANSWER",result);
        gotosecondActivity.putExtra("KEY_VALUEONE",value1);
        gotosecondActivity.putExtra("KEY_OPERATOR",operatorCode);
        gotosecondActivity.putExtra("KEY_VALUESEC",value2);
        startActivity(gotosecondActivity);
    }
}
