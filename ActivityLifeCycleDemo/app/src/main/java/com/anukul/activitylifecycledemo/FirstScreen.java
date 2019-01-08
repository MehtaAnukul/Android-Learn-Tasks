package com.anukul.activitylifecycledemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        Log.e("AndroidCycle","It's a onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("AndroidCycle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("AndroidCycle","onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("AndroidCycle","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("AndroidCycle","onRestart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("AndroidCycle","onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("AndroidCycle","onDestroy");
    }
}

