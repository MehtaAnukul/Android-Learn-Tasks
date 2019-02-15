package com.example.hitmer.officeexamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    protected boolean active = true;
    protected int splashScreenTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while (active && (waited < splashScreenTime)) {
                        sleep(500);
                        if (active) {
                            waited += 500;
                        }
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Error Loading App",Toast.LENGTH_SHORT).show();

                } finally {

                    startActivity(new Intent(SplashScreen.this,
                            MainActivity.class));
                    finish();
                }
            }
        };
        splashTread.start();
    }
}
