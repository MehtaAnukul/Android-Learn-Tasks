package com.example.hitmer.officeexamapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity implements HomeFragment.OnDbOpListener{
    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = findViewById(R.id.toobar);
        setSupportActionBar(mToolbar);

        if(findViewById(R.id.fragment_container)!=null)
        {
            if(savedInstanceState!=null)
            {
                return;
            }
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,homeFragment,null).commit();

        }
    }

    @Override
    public void dbOpPerformed(int method) {
        switch (method)
        {
            case 0:
                Intent intent = new Intent(this,SQLiteHomeActivity.class);
                startActivity(intent);
                break;

            case 1:
                intent = new Intent(this,RoomHomeActivity.class);
                startActivity(intent);
                break;
        }

    }
}

