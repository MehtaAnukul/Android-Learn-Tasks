package com.anukul.clickevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {
    private Button clickme;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

        clickme = findViewById(R.id.activity_count_click_btn1);
        clickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increaseInt();
            }
        });
    }


    public void increaseInt() {
        count = count + 1;
        TextView displayInt = (TextView) findViewById(R.id.activity_count_tv2);
        displayInt.setText("Integer:" + count);

    }

}
