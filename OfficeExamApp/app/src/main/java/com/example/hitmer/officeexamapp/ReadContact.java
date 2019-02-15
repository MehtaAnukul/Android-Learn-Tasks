package com.example.hitmer.officeexamapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadContact extends AppCompatActivity {
    private TextView txtViewData;
    private Toolbar mToolbar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<Contact> list;
    private RecyclerAdapter recyclerAdapter;
    Contact contact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_contact);
        recyclerView = findViewById(R.id.recycler_sqlite_View);
        mToolbar = findViewById(R.id.toobar);
        list = new ArrayList<>();
        readContact();

        layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerAdapter = new RecyclerAdapter(this,list);
        recyclerView.setAdapter(recyclerAdapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.appbar_menu,menu);
        return true;
    }
    private void readContact()
    {
        ContactdBHelper contactdBHelper = new ContactdBHelper(this);
        SQLiteDatabase database = contactdBHelper.getReadableDatabase();

        Cursor cursor = contactdBHelper.readContacts(database);

        while (cursor.moveToNext())
        {
            String id = Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.contactEntry.CONTACT_ID)));
            String firstname = cursor.getString(cursor.getColumnIndex(ContactContract.contactEntry.FIRSTNAME));
            String lastname = cursor.getString(cursor.getColumnIndex(ContactContract.contactEntry.LASTNAME));
            String phoneno = cursor.getString(cursor.getColumnIndex(ContactContract.contactEntry.PHONENO));
            String Email = cursor.getString(cursor.getColumnIndex(ContactContract.contactEntry.EMAIL));

            list.add(new Contact(id,firstname,lastname,phoneno,Email));
        }
//        Toast.makeText(this,"Reading Success",Toast.LENGTH_LONG).show();
        contactdBHelper.close();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.action_person_add:
                Intent intent = new Intent(this,AddContact.class);
                startActivity(intent);
                //DisplayMessage("Add Menu Selected...");
                return true;

            case R.id.action_search:
                DisplayMessage("Search Menu Selected...");
                return true;

            case R.id.action_settings:
                DisplayMessage("Settings Menu Selected...");
                return true;

            case R.id.action_person_view:
                intent = new Intent(this,ReadContact.class);
                startActivity(intent);
//                DisplayMessage("View Menu Selected...");
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
