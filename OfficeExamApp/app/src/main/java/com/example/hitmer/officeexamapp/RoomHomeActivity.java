package com.example.hitmer.officeexamapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class RoomHomeActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_home);
        mToolbar = findViewById(R.id.toobar);
        setSupportActionBar(mToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_person_add:
                DisplayMessage("Add Menu Selected...");
                return true;

            case R.id.action_search:
                DisplayMessage("Search Menu Selected...");
                return true;

            case R.id.action_settings:
                DisplayMessage("Settings Menu Selected...");
                return true;

            case R.id.action_person_view:
                DisplayMessage("View Menu Selected...");
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void DisplayMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
