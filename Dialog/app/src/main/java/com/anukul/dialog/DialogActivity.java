package com.anukul.dialog;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;


public class DialogActivity extends AppCompatActivity implements View.OnClickListener , SeekBar.OnSeekBarChangeListener {

    private Button alertBtn;
    private Button timeBtn;
    private Button customBtn;
    private Button colorBtn;

    //colorPickerDialog
    private SeekBar colorRedSk;
    private SeekBar colorGreenSk;
    private SeekBar colorBlueSk;
    private SeekBar colorAlphaSk;
    RelativeLayout colorPreview;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int alpha = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        initView();

    }


    private void initView() {
        alertBtn = findViewById(R.id.activity_dialog_alertBtn);
        timeBtn = findViewById(R.id.activity_dialog_timepickerBtn);
        customBtn = findViewById(R.id.activity_dialog_customDialogBtn);
        colorBtn = findViewById(R.id.activity_dialog_colorPickerDialogBtn);

        alertBtn.setOnClickListener(this);
        timeBtn.setOnClickListener(this);
        customBtn.setOnClickListener(this);
        colorBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_dialog_alertBtn:
                openAlertDialog();
                break;
            case R.id.activity_dialog_timepickerBtn:
                openTimePickerDialog();
                break;
            case R.id.activity_dialog_customDialogBtn:
                openCustomDialog();
                break;
            case R.id.activity_dialog_colorPickerDialogBtn:
                openColorPickerDialog();
                break;
        }

    }

    private void openColorPickerDialog() {

        final AppCompatDialog appCompatDialog = new AppCompatDialog(DialogActivity.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);

        appCompatDialog.setContentView(R.layout.colorpicker_dialog);
        appCompatDialog.setTitle("ColorPickerDialog");
        appCompatDialog.show();

        colorRedSk = appCompatDialog.findViewById(R.id.activity_colorpicker_redSeekbar);
        colorGreenSk = appCompatDialog.findViewById(R.id.activity_colorpicker_greenSeekbar);
        colorBlueSk = appCompatDialog.findViewById(R.id.activity_colorpicker_blueSeekbar);
        colorAlphaSk = appCompatDialog.findViewById(R.id.activity_colorpicker_alphaSeekbar);
        colorPreview = appCompatDialog.findViewById(R.id.activity_colorpicker_relativelayout);

        colorRedSk.setOnSeekBarChangeListener(this);
        colorGreenSk.setOnSeekBarChangeListener(this);
        colorBlueSk.setOnSeekBarChangeListener(this);
        colorAlphaSk.setOnSeekBarChangeListener(this);
        

    }


    private void openCustomDialog() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(DialogActivity.this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);

        appCompatDialog.setContentView(R.layout.custom_dialog);
        appCompatDialog.setTitle("Custom");

        appCompatDialog.show();
        final Button dialogBtn = appCompatDialog.findViewById(R.id.activity_customDialog_btn);

        dialogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DialogActivity.this, "Custom Btn", Toast.LENGTH_SHORT).show();
                appCompatDialog.dismiss();
            }
        });


    }

    private void openTimePickerDialog() {
        final Calendar calendar = Calendar.getInstance();

        final int mHour = calendar.get(Calendar.HOUR);
        final int mMinute = calendar.get(Calendar.MINUTE);

        final TimePickerDialog timePickerDialog = new TimePickerDialog(DialogActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                timeBtn.setText(hourOfDay + ":" + minute);
            }
        }, mHour, mMinute, false);

        timePickerDialog.show();
    }

    private void openAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(DialogActivity.this);

        builder.setTitle("Delete ?");
        builder.setMessage("Are you sure ?");
        builder.setCancelable(false);

        builder.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "delete conform", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(DialogActivity.this, "msd No delete", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    //ColorPickerDialog --> SeekBar Code
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.activity_colorpicker_redSeekbar:
                Toast.makeText(this,"RED SEEKBAR",Toast.LENGTH_SHORT).show();
                red = progress;
                break;
            case R.id.activity_colorpicker_greenSeekbar:
                Toast.makeText(this,"GREEN SEEKBAR",Toast.LENGTH_SHORT).show();
                green = progress;
                break;
            case R.id.activity_colorpicker_blueSeekbar:
                Toast.makeText(this,"BLUE SEEKBAR",Toast.LENGTH_SHORT).show();
                blue = progress;
                break;
            case R.id.activity_colorpicker_alphaSeekbar:
                Toast.makeText(this,"ALPHA SEEKBAR",Toast.LENGTH_SHORT);
                alpha = progress;
                break;
        }
        colorPreview.setBackgroundColor(Color.argb(alpha,red,green,blue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
