package com.anukul.intentdemotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.PriorityQueue;

public class SecondActivity extends AppCompatActivity {

    private TextView nameTv;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
        intent = getIntent();


      String yourName =  intent.getStringExtra("KEY_NAME");
        nameTv.setText(yourName);

    }

    private void initView() {
        nameTv = findViewById(R.id.activity_second_nameTv);


    }
}
