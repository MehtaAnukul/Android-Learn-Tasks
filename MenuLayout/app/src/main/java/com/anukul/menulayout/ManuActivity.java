package com.anukul.menulayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class ManuActivity extends AppCompatActivity implements View.OnClickListener{

    private Button contextManuBtn;
    private Button popUpManuBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manu);

        contextManuBtn = findViewById(R.id.activity_manu_contextBtn);
        popUpManuBtn = findViewById(R.id.activity_manu_popUpBtn);

        registerForContextMenu(contextManuBtn);

        popUpManuBtn.setOnClickListener(this);
    }
    //Context Manu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.whatsapp_manu,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.whatsapp_manu_newGroup:
                Toast.makeText(this,"New Group",Toast.LENGTH_SHORT).show();
                break;
            case R.id.whatsapp_manu_newBroadcast:
                Toast.makeText(this,"New Broadcast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.whatsapp_manu_whatsAppWeb:
                Toast.makeText(this,"Whatsapp Web",Toast.LENGTH_SHORT).show();
                break;
//            case R.id.whatsapp_manu_starredMsg:
//                Toast.makeText(this,"starred msg",Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.whatsapp_manu_setting:
//                Toast.makeText(this,"Setting",Toast.LENGTH_SHORT).show();
//                break;
        }
        return super.onContextItemSelected(item);
    }

    //option Manu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.whatsapp_manu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.whatsapp_manu_newGroup:
                Toast.makeText(this,"New Group",Toast.LENGTH_SHORT).show();
                break;
            case R.id.whatsapp_manu_newBroadcast:
                Toast.makeText(this,"New Broadcast",Toast.LENGTH_SHORT).show();
                break;
            case R.id.whatsapp_manu_whatsAppWeb:
                Toast.makeText(this,"Whatsapp Web",Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }


    //PopUpManu
    @Override
    public void onClick(View v) {

        PopupMenu popupMenu = new PopupMenu(this,v);

        getMenuInflater().inflate(R.menu.whatsapp_manu,popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.whatsapp_manu_newGroup:
                        Toast.makeText(ManuActivity.this,"New Group",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.whatsapp_manu_newBroadcast:
                        Toast.makeText(ManuActivity.this,"New Broadcast",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.whatsapp_manu_whatsAppWeb:
                        Toast.makeText(ManuActivity.this,"Whatsapp Web",Toast.LENGTH_SHORT).show();
                        break;

                }
                return false;
            }
        });

    }
}
