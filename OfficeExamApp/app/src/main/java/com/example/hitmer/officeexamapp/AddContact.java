package com.example.hitmer.officeexamapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddContact extends AppCompatActivity {

    private Button btnSaved;
    private EditText id,firstname,lastname,phoneno,email;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);
        mToolbar = findViewById(R.id.toobar);
        setSupportActionBar(mToolbar);
        id = findViewById(R.id.edt_id);
        firstname = findViewById(R.id.edtFirstName);
        lastname = findViewById(R.id.edtLastName);
        phoneno = findViewById(R.id.edtPhoneno);
        email = findViewById(R.id.edtEmail);
        btnSaved = findViewById(R.id.btnInsert);

        btnSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Id = id.getText().toString();
                String Firstname = firstname.getText().toString();
                String LastName = lastname.getText().toString();
                String Phoneno = phoneno.getText().toString();
                String Email = email.getText().toString();
                for(int i=0; i<10;i++) {

                    ContactdBHelper contactdBHelper = new ContactdBHelper(getApplicationContext());
                    SQLiteDatabase sqLiteDatabase = contactdBHelper.getWritableDatabase();
                    contactdBHelper.addContact(Integer.parseInt(Id), Firstname, LastName,Phoneno,Email, sqLiteDatabase);
                    contactdBHelper.close();

                }


                id.setText("");
                firstname.setText("");
                lastname.setText("");
                phoneno.setText("");
                email.setText("");
                Toast.makeText(getApplicationContext(),"Insert Success",Toast.LENGTH_LONG).show();

            }
        });

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