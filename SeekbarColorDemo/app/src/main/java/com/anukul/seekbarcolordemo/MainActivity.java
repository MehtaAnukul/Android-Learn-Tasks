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
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int alpha = 0;

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
                red = progress;
                break;
            case R.id.activity_main_seekbarGreen:
                Toast.makeText(this, "GREEN", Toast.LENGTH_SHORT).show();
                green = progress;
                break;
            case R.id.activity_main_seekbarBlue:
                Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show();
                blue = progress;
                break;
            case R.id.activity_main_seekbarAlpha:
                Toast.makeText(this, "Alpha", Toast.LENGTH_SHORT).show();
                alpha = progress;
                break;
        }

        colorPreview.setBackgroundColor(Color.argb(alpha, red, green, blue));
        colorCodeTv.setText(String.valueOf("#"+String.format("%02x", red)
                +String.format("%02x", green)+String.format("%02x", blue)+String.format("%02x", alpha)));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
