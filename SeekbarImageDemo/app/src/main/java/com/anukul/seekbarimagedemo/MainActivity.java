package com.anukul.seekbarimagedemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener {
    float textsize;

    private ImageView imageIv;
    private TextView captionTv;
    private RadioGroup radioGroup;
    private RadioButton selectOptionRb;
    private SeekBar widthSb;
    private SeekBar heightSb;
    private SeekBar captionTextSizeSb;
    private TextView captionTextSizeTv;
    private Property<View, Float> scaleY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        imageIv = findViewById(R.id.activity_main_imgView);
        captionTv = findViewById(R.id.activity_main_captionTv);
        radioGroup = findViewById(R.id.activity_main_radioGroup);
        widthSb = findViewById(R.id.activity_main_width_sk);
        heightSb = findViewById(R.id.activity_main_height_sk);
        selectOptionRb = findViewById(radioGroup.getCheckedRadioButtonId());
        captionTextSizeSb = findViewById(R.id.activity_main_caption_sk);
        captionTextSizeTv = findViewById(R.id.activity_main_captionTextSizeTv);
        radioGroup.setOnCheckedChangeListener(this);
        widthSb.setOnSeekBarChangeListener(this);
        heightSb.setOnSeekBarChangeListener(this);
        captionTextSizeSb.setOnSeekBarChangeListener(this);

        if (selectOptionRb.getText().equals(getString(R.string.img))) {
            imageIv.requestLayout();
            imageIv.getLayoutParams().width = widthSb.getProgress();
            imageIv.getLayoutParams().height = heightSb.getProgress();
            imageIv.setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()) {
            case R.id.activity_main_width_sk:
                changeWidth(progress);
                break;
            case R.id.activity_main_height_sk:
                changeHeight(progress);
                break;
            case R.id.activity_main_caption_sk:
                increaseTextSize(progress);
                break;
        }
    }

    private void increaseTextSize(int progress) {
        // captionTv.requestLayout();
        //textsize = textsize + 1;
        //captionTv.setTextSize(textsize);
        captionTv.setTextSize(progress);
        Toast.makeText(this, "Increase CaptionTextSize", Toast.LENGTH_SHORT).show();
    }

    private void changeHeight(int progres) {
        if (selectOptionRb.getText().equals(getString(R.string.caption))) {
            captionTv.requestLayout();
            captionTv.getLayoutParams().height = progres;
            Toast.makeText(this, "Change Caption Height", Toast.LENGTH_SHORT).show();
        } else if (selectOptionRb.getText().equals(getString(R.string.img))) {

            imageIv.requestLayout();
            imageIv.getLayoutParams().height = progres;
            imageIv.setScaleType(ImageView.ScaleType.FIT_XY);

            Toast.makeText(this, "Change img Height", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Occur", Toast.LENGTH_SHORT).show();
        }
    }


    private void changeWidth(int progres) {
        if (selectOptionRb.getText().equals(getString(R.string.caption))) {
            // captionTv.requestLayout();
            //captionTv.getLayoutParams().width = progres;
            captionTv.requestLayout();
            captionTv.getLayoutParams().width = progres;

            Toast.makeText(this, "Change Caption width", Toast.LENGTH_SHORT).show();
        } else if (selectOptionRb.getText().equals(getString(R.string.img))) {

            imageIv.requestLayout();
            imageIv.getLayoutParams().width = progres;
            imageIv.setScaleType(ImageView.ScaleType.FIT_XY);


            Toast.makeText(this, "Change img width", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error Occur", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        selectOptionRb = findViewById(checkedId);
        switch (checkedId) {
            case R.id.activity_main_captionRb:
                captionTextSizeSb.setVisibility(View.VISIBLE);
                captionTextSizeTv.setVisibility(View.VISIBLE);
                break;
            case R.id.activity_main_imgRb:
                captionTextSizeSb.setVisibility(View.INVISIBLE);
                captionTextSizeTv.setVisibility(View.INVISIBLE);
                break;
        }

    }


}
