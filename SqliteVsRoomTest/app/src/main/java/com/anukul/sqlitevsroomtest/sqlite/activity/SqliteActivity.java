package com.anukul.sqlitevsroomtest.sqlite.activity;


import android.app.ProgressDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.anukul.sqlitevsroomtest.R;
import com.anukul.sqlitevsroomtest.app.ContactDbConstant;
import com.anukul.sqlitevsroomtest.sqlite.ContactDbHelper;
import com.anukul.sqlitevsroomtest.sqlite.fragment.SqlitReadContactFragment;
import com.anukul.sqlitevsroomtest.sqlite.fragment.SqliteAddFragment;
import com.anukul.sqlitevsroomtest.sqlite.model.ContactModel;

import java.util.ArrayList;
import java.util.Random;

public class SqliteActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private FragmentManager fragmentManager;

    private Toolbar toolbar;
    private Random mRandom;
    private ContactDbHelper contactDbHelper;
    private long start_time, end_time, total_time;

    private ProgressDialog progressDialog;
    String random[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"
            , "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x"
            , "y", "z"};
    String randomNumberArray[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        toolbar = findViewById(R.id.toolbar_layout_toolbar);
        setSupportActionBar(toolbar);

        progressDialog = new ProgressDialog(SqliteActivity.this);
        mRandom = new Random();

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.appbar_menu_searchIcon);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    public String randomSting() {
        String randomName = "";
        for (int i = 0; i < 6; i++)
            randomName = randomName.concat(random[mRandom.nextInt(25)]);
        return randomName;
    }

    public String randomNumber() {
        String randomNumber = "";
        for (int i = 0; i < 10; i++) {
            randomNumber = randomNumber.concat(randomNumberArray[mRandom.nextInt(9)]);
        }
        return randomNumber;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.appbar_menu_insertData:

                contactDbHelper = new ContactDbHelper(getApplicationContext());
                SQLiteDatabase sqLiteDatabase = contactDbHelper.getWritableDatabase();

                ContentValues values = new ContentValues();
                start_time = System.currentTimeMillis();
                progressDialog.setMessage("Please wait Data inserted..");
                for (int i = 0; i < 1000; i++) {
                    progressDialog.show();
                    values.put(ContactDbConstant.CONTACT_COLUMN_NAME, randomSting());
                    values.put(ContactDbConstant.CONTACT_COLUMN_LASTNAME, randomSting());
                    values.put(ContactDbConstant.CONTACT_COLUMN_PHONE_NO, randomNumber());
                    values.put(ContactDbConstant.CONTACT_COLUMN_EMAIL, randomSting().concat("@gmail.com"));
                    sqLiteDatabase.insert(ContactDbConstant.CONTACT_TABALE_NAME, null, values);
                }
                progressDialog.dismiss();
                end_time = System.currentTimeMillis();
                total_time = end_time - start_time;
                Toast.makeText(this, total_time + " mili seconds", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "insert success", Toast.LENGTH_SHORT).show();
                break;
            case R.id.appbar_menu_ViewData:
                progressDialog.setMessage("Please wait..");
                progressDialog.show();
                SqliteAddFragment sqliteAddFragmentt = new SqliteAddFragment();
                SqlitReadContactFragment sqlitReadContactFragment = new SqlitReadContactFragment();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.activity_sqlite_fragment_container, sqlitReadContactFragment, SqliteActivity.class.getSimpleName());
                //fragmentTransaction1.addToBackStack(ReadContactsFragment.class.getSimpleName());
                progressDialog.dismiss();
                fragmentTransaction1.hide(sqliteAddFragmentt);
                fragmentTransaction1.commit();
                break;

            case R.id.appbar_menu_searchIcon:
                MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionExpand(MenuItem menuItem) {
                        Toast.makeText(SqliteActivity.this, "Action View Expanded", Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                        Toast.makeText(SqliteActivity.this, "Action View Collapsed", Toast.LENGTH_SHORT).show();
                        return true;
                    }
                };

                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String s) {
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        String usertext = s.toLowerCase();
        ArrayList<ContactModel> searchArrayList = new ArrayList<>();

        for (int i = 0; i < SqlitReadContactFragment.getContactModelArrayList().size(); i++) {
            if (SqlitReadContactFragment.getContactModelArrayList().get(i).getName().toLowerCase().contains(usertext)
                    || SqlitReadContactFragment.getContactModelArrayList().get(i).getEmail().toLowerCase().contains(usertext)
                    || SqlitReadContactFragment.getContactModelArrayList().get(i).getPhoneNo().toLowerCase().contains(usertext)
                    || SqlitReadContactFragment.getContactModelArrayList().get(i).getLastName().toLowerCase().toLowerCase().contains(usertext)) {
                searchArrayList.add(SqlitReadContactFragment.getContactModelArrayList().get(i));
            }
        }
        Log.e("DOST1", SqlitReadContactFragment.getContactModelArrayList() + "");
        Log.e("DOST2", searchArrayList + "");
        SqlitReadContactFragment.getReadContactAdapter().updateList(searchArrayList);
        return true;
    }
}
