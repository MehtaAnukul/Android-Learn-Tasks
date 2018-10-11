package com.anukul.utus;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class StartGameActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = StartGameActivity.class.getSimpleName();
    int count = 0;
    int live = 3;
    private TextView scoreTv;
    private TextView livesTv;

    private Button randomBtnColor;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;

    private Button startBtn;

    private Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initView();
    }

    private void initView() {
        scoreTv = findViewById(R.id.activity_play_scoreTv);
        livesTv = findViewById(R.id.activity_play_livesTv);
        btn1 = findViewById(R.id.activity_play_btn1);
        btn2 = findViewById(R.id.activity_play_btn2);
        btn3 = findViewById(R.id.activity_play_btn3);
        btn4 = findViewById(R.id.activity_play_btn4);
        btn5 = findViewById(R.id.activity_play_btn5);
        btn6 = findViewById(R.id.activity_play_btn6);
        btn7 = findViewById(R.id.activity_play_btn7);
        btn8 = findViewById(R.id.activity_play_btn8);
        btn9 = findViewById(R.id.activity_play_btn9);
        startBtn = findViewById(R.id.activity_second_startBtn);

        scoreTv.setOnClickListener(this);
        livesTv.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        startBtn.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_second_startBtn:
                Log.e(TAG, "onClick: ");
                Toast.makeText(StartGameActivity.this, "Game are started", Toast.LENGTH_LONG).show();
                startGame();
                break;
            case R.id.activity_play_btn1:
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn2:
                //int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn3:
                btnColor();
                startGame();
                //color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                break;
            case R.id.activity_play_btn4:
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn5:
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn6:
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn7:
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn8:
                btnColor();
                startGame();
                break;
            case R.id.activity_play_btn9:
                btnColor();
                startGame();
                break;
        }
    }
    private void decreaseLive() {
        live = live - 1;
        TextView decreaselive = (TextView) findViewById(R.id.activity_play_livesTv);
        decreaselive.setText(live + "");
        if (live == 0) {
            finish();
        }
    }
    private void increaseScore() {
        count = count + 10;
        TextView displayScore = (TextView) findViewById(R.id.activity_play_scoreTv);
        displayScore.setText(count + "");
    }
    private void startGame() {
        int randome;
        Button btn[] = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        randome = rnd.nextInt(btn.length);
        randomBtnColor = btn[randome];
        Log.e(TAG, randome + " NUM");
        //  bt.setBackgroundColor(Color.argb(255,rnd.nextInt(256),rnd.nextInt(256),rnd.nextInt(256)));
        randomBtnColor.setBackgroundColor(Color.GREEN);
    }

    private void btnColor() {
        if (randomBtnColor.isClickable() == randomBtnColor.isPressed()) {
            Log.e(TAG, "increase");
            increaseScore();
        } else {
            Log.e(TAG, "decrease");
            decreaseLive();
        }
        randomBtnColor.setBackgroundColor(getResources().getColor(R.color.colorGray));
    }
}


