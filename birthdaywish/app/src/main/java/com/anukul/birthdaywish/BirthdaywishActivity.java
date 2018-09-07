package com.anukul.birthdaywish;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class BirthdaywishActivity extends AppCompatActivity {
    private TextView wishmsg;
    private EditText editText;
    private Button clickbtn;
    private Button txtcolorbtn;
    private Button bgtxtcolorbtn;
    private Random rnd = new Random();
    private String temp = "Mimoh";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthdaywish);

        wishmsg = findViewById(R.id.activity_birthdaywish_wishmsg_tv);
        editText = findViewById(R.id.activity_birthdaywish_et);
        clickbtn = findViewById(R.id.activity_birthdaywish_clickbtn);
        txtcolorbtn = findViewById(R.id.activity_birthdaywish_txtcolorbtn);
        bgtxtcolorbtn = findViewById(R.id.activity_birthdaywish_bgtxtcolorbtn);

        clickbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Toast.makeText(BirthdaywishActivity.this,"replce loading",Toast.LENGTH_LONG).show();
                String name = wishmsg.getText().toString();
//                Log.e("BirthdaywishActivity" , name);
                //name.replace("Mimoh",editText.getText());
                wishmsg.setText(name.replace(temp,editText.getText()));
                temp = editText.getText().toString();
               // Log.e("BirthdaywishActivity",);
            }
        });

        txtcolorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // wishmsg.setTextColor(Color.argb(255,255,70,90));
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                wishmsg.setTextColor(color);
            }
        });

        bgtxtcolorbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                wishmsg.setBackgroundColor(color);
            }
        });


    }
}
