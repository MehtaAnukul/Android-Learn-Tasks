package com.anukul.intentdemotask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText nameEd;
    private Button clickBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        nameEd = findViewById(R.id.activity_main_name_et);
        clickBtn = findViewById(R.id.activity_main_btn);

        clickBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_btn:
                gotoSecondActivity();
                break;
        }

    }

    private void gotoSecondActivity() {

        final Intent gotoSecondActivity = new Intent(MainActivity.this, SecondActivity.class);
        gotoSecondActivity.putExtra("KEY_NAME",nameEd.getText().toString().trim());
        startActivity(gotoSecondActivity);


    }
}
