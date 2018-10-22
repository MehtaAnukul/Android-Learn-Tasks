package com.anukul.seekbarcolordemo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    int colorCode;
    private TextView colorCodeTv;

    private SeekBar colorRedSk;
    private SeekBar colorGreenSk;
    private SeekBar colorBlueSk;
    private SeekBar colorAlphaSk;
    private RelativeLayout colorPreview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        colorCodeTv = findViewById(R.id.activity_main_colorCodeTv);
        colorRedSk = findViewById(R.id.activity_main_seekbarRed);
        colorGreenSk = findViewById(R.id.activity_main_seekbarGreen);
        colorBlueSk = findViewById(R.id.activity_main_seekbarBlue);
        colorAlphaSk = findViewById(R.id.activity_main_seekbarAlpha);
        colorPreview = findViewById(R.id.activity_main_reletivelayout);

        colorRedSk.setOnSeekBarChangeListener(this);
        colorGreenSk.setOnSeekBarChangeListener(this);
        colorBlueSk.setOnSeekBarChangeListener(this);
        colorAlphaSk.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.activity_main_seekbarRed:
                Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show();
                int redColor = Color.argb(255, progress, 0, 0);
                colorPreview.setBackgroundColor(redColor);
                colorCodeTv.setText(String.valueOf(redColor));
                break;
            case R.id.activity_main_seekbarGreen:
                Toast.makeText(this, "GREEN", Toast.LENGTH_SHORT).show();
                 int greenColor = Color.argb(255,0,progress,0);
                 colorPreview.setBackgroundColor(greenColor);
                colorCodeTv.setText(String.valueOf(greenColor));
                break;
            case R.id.activity_main_seekbarBlue:
                Toast.makeText(this,"Blue",Toast.LENGTH_SHORT).show();
                int blueColor = Color.argb(255,0,0,progress);
                colorPreview.setBackgroundColor(blueColor);
                colorCodeTv.setText(String.valueOf(blueColor));
                break;
            case R.id.activity_main_seekbarAlpha:
                Toast.makeText(this,"Alpha",Toast.LENGTH_SHORT).show();
                int alphaColor = Color.argb(progress,0,0,0);
                colorPreview.setBackgroundColor(alphaColor);
                colorCodeTv.setText(String.valueOf(alphaColor));
                break;
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
