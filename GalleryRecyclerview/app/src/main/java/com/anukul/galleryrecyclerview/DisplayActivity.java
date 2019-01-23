package com.anukul.galleryrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DisplayActivity extends AppCompatActivity {
    private ImageView displayimageView;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayimageView = findViewById(R.id.activty_display_imageView);

        intent = getIntent();

        displayimageView.setImageResource(intent.getIntExtra(AppConstant.KEY_IMG,10));
    }
}
