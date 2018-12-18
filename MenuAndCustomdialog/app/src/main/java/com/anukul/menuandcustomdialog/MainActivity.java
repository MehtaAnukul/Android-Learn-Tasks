package com.anukul.menuandcustomdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListView.OnItemLongClickListener {
    private ListView nameListView;

    ArrayList<String> stringNameArrayList;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameListView = findViewById(R.id.activity_main_listView);
        stringNameArrayList = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(MainActivity.this,
                R.layout.person_name,
                R.id.person_name_Tv, stringNameArrayList);


        nameListView.setAdapter(arrayAdapter);

        nameListView.setOnItemLongClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.whatsapp_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.whatsapp_menu_newGroup:
                openCustomAlertDialog();
                Toast.makeText(this, "New Group", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openCustomAlertDialog() {

        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);
        appCompatDialog.setContentView(R.layout.customalert_dialog);
        appCompatDialog.setTitle("Custom");
        appCompatDialog.show();

        final EditText nameEd = appCompatDialog.findViewById(R.id.customalert_dialog_nameEd);
        final Button click = appCompatDialog.findViewById(R.id.customalert_dialog_clickBtn);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEd.getText().toString().trim();

                stringNameArrayList.add(name);
                arrayAdapter.notifyDataSetChanged();
                appCompatDialog.dismiss();
            }
        });

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long temp) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete ");
        builder.setMessage("Are you sure you want to delete ?");
        builder.setCancelable(false);
        final int id = position;
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Item Deleted", Toast.LENGTH_SHORT).show();
                stringNameArrayList.remove(id);
                arrayAdapter.notifyDataSetChanged();

            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Item not Delete !", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();


        return false;
    }


}


