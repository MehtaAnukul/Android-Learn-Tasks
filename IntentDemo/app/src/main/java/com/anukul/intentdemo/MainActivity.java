package com.anukul.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e(TAG, "onCreate " );

        initView();

    }

    private void initView() {
        btn = findViewById(R.id.activity_main_btn);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.activity_main_btn:
                secondActivity();
                break;
        }
    }

    private void secondActivity() {
        final Intent gotoSencondActivity = new Intent(MainActivity.this,SecondActivity.class);
        startActivity(gotoSencondActivity);
    }
    protected void onStart(){
        super.onStart();
        Log.e(TAG,"onStart");
    }

    protected void onResume(){
        super.onResume();
        Log.e(TAG,"onResume");
    }
    protected void onPause(){
        super.onPause();
        Log.e(TAG,"onPause");
    }

    protected void onRestart(){
        super.onRestart();
        Log.e(TAG,"onRestart");
    }
    protected void onStop(){
        super.onStop();
        Log.e(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");
    }
}
