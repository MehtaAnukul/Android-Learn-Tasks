package com.anukul.utus;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FrontPagePlayActivity extends AppCompatActivity implements View.OnClickListener{

    private Button playBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        playBtn = findViewById(R.id.activity_main_playBtn);

        playBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_playBtn:
                opensecondActivity();
                break;
        }
    }

    private void opensecondActivity() {
        final Intent gotoSecondActivity = new Intent(FrontPagePlayActivity.this,StartGameActivity.class);
        startActivity(gotoSecondActivity);
    }
}
