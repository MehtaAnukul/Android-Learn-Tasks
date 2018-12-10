package com.anukul.clickevents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FontStyleActivity extends AppCompatActivity {

    private TextView txtSampleTv;
    private RelativeLayout relativeLayout;
    private float txtSize;

    private Button increaseBtn;
    private Button decreaseBtn;

    private Button parentbgRedBtn;
    private Button parentbgBlueBtn;
    private Button parentbgYellowBtn;
    private Button parentbgGreenBtn;

    private Button txtColorRedBtn;
    private Button txtColorBlueBtn;
    private Button txtColorYellowBtn;
    private Button txtColorGreenBtn;

    private Button bgtxtRedBtn;
    private Button bgtxtBlueBtn;
    private Button bgtxtYellowBtn;
    private Button bgtxtGreenBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fontstyle);

        increaseBtn = findViewById(R.id.activity_increase_btn);
        decreaseBtn = findViewById(R.id.activity_decrease_btn);

        parentbgRedBtn = findViewById(R.id.activity_fontstyle_parentbg_redbtn);
        parentbgBlueBtn = findViewById(R.id.activity_fontstyle_parentbg_bluebtn);
        parentbgYellowBtn = findViewById(R.id.activity_fontstyle_parentbg_yellowbtn);
        parentbgGreenBtn = findViewById(R.id.activity_fontstyle_parentbg_greenbtn);

        txtColorRedBtn = findViewById(R.id.activity_fontstyle_txtcolor_redbtn);
        txtColorBlueBtn = findViewById(R.id.activity_fontstyle_txtcolor_bluebtn);
        txtColorYellowBtn = findViewById(R.id.activity_fontstyle_txtcolor_yellowbtn);
        txtColorGreenBtn = findViewById(R.id.activity_fontstyle_txtcolor_greenbtn);

        bgtxtRedBtn = findViewById(R.id.activity_fontstyle_bgtxtcolor_redbtn);
        bgtxtBlueBtn = findViewById(R.id.activity_fontstyle_bgtxtcolor_bluebtn);
        bgtxtYellowBtn = findViewById(R.id.activity_fontstyle_bgtxtcolor_yellowbtn);
        bgtxtGreenBtn = findViewById(R.id.activity_fontstyle_bgtxtcolor_greenbtn);

        txtSampleTv = findViewById(R.id.activity_sample_tv);
        txtSize = txtSampleTv.getTextSize();
        txtSampleTv.setTextSize(txtSize);

        relativeLayout = findViewById(R.id.activity_fontstyle_relative);
        // Log.e("FontStyleActivity", "ORIGINAL SIZE  : " + txtSize);

        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e("FontStyleActivity", "TXTSIZE (+) : " + txtSampleTv.getTextSize());
                txtSize = txtSize + 1;
                // Log.e("FontStyleActivity", "ORIGINAL SIZE (NEW)  : " + txtSize);
                txtSampleTv.setTextSize(txtSize);

            }
        });

        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSize = txtSize - 1;
                // Log.e("FontStyleActivity", "TXTSIZE (-) : " + txtSize);
                txtSampleTv.setTextSize(txtSize);

            }
        });

        parentbgRedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorRed));
            }
        });

        parentbgBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorblue));
            }
        });

        parentbgYellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            }
        });

        parentbgGreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        });


        txtColorRedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setTextColor(getResources().getColor(R.color.colorRed));
            }
        });

        txtColorBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setTextColor(getResources().getColor(R.color.colorblue));
            }
        });

        txtColorYellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setTextColor(getResources().getColor(R.color.colorYellow));
            }
        });

        txtColorGreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setTextColor(getResources().getColor(R.color.colorGreen));
            }
        });

        bgtxtRedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setBackgroundColor(getResources().getColor(R.color.colorRed));
            }
        });

        bgtxtBlueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setBackgroundColor(getResources().getColor(R.color.colorblue));
            }
        });

        bgtxtYellowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            }
        });

        bgtxtGreenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSampleTv.setBackgroundColor(getResources().getColor(R.color.colorGreen));
            }
        });


    }
}
