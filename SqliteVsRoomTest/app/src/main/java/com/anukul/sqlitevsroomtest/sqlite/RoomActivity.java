package com.anukul.sqlitevsroomtest.sqlite;

import android.app.ProgressDialog;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.anukul.sqlitevsroomtest.R;
import com.anukul.sqlitevsroomtest.roomDatabase.MyAppDatabase;
import com.anukul.sqlitevsroomtest.roomModel.UserModel;
import com.anukul.sqlitevsroomtest.roomfragment.RoomAddFragment;
import com.anukul.sqlitevsroomtest.roomfragment.RoomReadUserFragment;
import com.anukul.sqlitevsroomtest.sqlite.activity.SqliteActivity;
import com.anukul.sqlitevsroomtest.sqlite.fragment.SqlitReadContactFragment;

import java.util.ArrayList;
import java.util.Random;

public class RoomActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private Toolbar toolbar;

    private FragmentManager fragmentManager;
    public static MyAppDatabase myAppDatabase;

    private Random mRandom;
    private long start_time, end_time, total_time;
    private ProgressDialog progressDialog;

    String random[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m"
            , "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x"
            , "y", "z"};
    String randomNumberArray[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    String randomComDomainArray[] = {"@gmail.com","@yahoo.in","@yahoo.com"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        toolbar = findViewById(R.id.toolbar_layout_toolbar);
        setSupportActionBar(toolbar);

        fragmentManager = getSupportFragmentManager();
        myAppDatabase = Room.databaseBuilder(getApplicationContext(), MyAppDatabase.class, "userdb").allowMainThreadQueries().build();

        progressDialog = new ProgressDialog(RoomActivity.this);
        mRandom = new Random();

        fragmentManager = getSupportFragmentManager();
    }

    public String randomSting(){
     String randomName = "";
     for(int i=0;i<6;i++){
         randomName = randomName.concat(random[mRandom.nextInt(25)]);
     }
     return randomName;
    }

    public String randomNumber(){
        String randomNamber = "";
        for (int i=0;i<10;i++){
            randomNamber = randomNamber.concat(randomNumberArray[mRandom.nextInt(9)]);
        }
        return randomNamber;
    }
    public String randomComDomain(){
        String randomComDomain = "";
        randomComDomain = randomComDomain.concat(randomComDomainArray[mRandom.nextInt(3)]);

        return  randomComDomain;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.appbar_menu_searchIcon);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.appbar_menu_insertData:

               /* RoomReadUserFragment roomReadUserFragmentt = new RoomReadUserFragment();

                RoomAddFragment roomAddFragment = new RoomAddFragment();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.activity_room_fragment_container,roomAddFragment,RoomActivity.class.getSimpleName());
                fragmentTransaction.hide(roomReadUserFragmentt);
                fragmentTransaction.commit();*/
                MyAsynctask myAsynctask = new MyAsynctask();
                myAsynctask.execute();
                break;

            case R.id.appbar_menu_ViewData:
                progressDialog.setMessage("Please wait..");
                progressDialog.show();
                RoomAddFragment roomAddFragmentt = new RoomAddFragment();

                RoomReadUserFragment roomReadUserFragment = new RoomReadUserFragment();
                FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.activity_room_fragment_container,roomReadUserFragment,RoomActivity.class.getSimpleName());
                progressDialog.dismiss();
                fragmentTransaction1.hide(roomAddFragmentt);
                fragmentTransaction1.commit();
                break;
            case R.id.appbar_menu_searchIcon:

                MenuItem.OnActionExpandListener onActionExpandListener = new MenuItem.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionExpand(MenuItem menuItem) {
                        Toast.makeText(RoomActivity.this, "Action View Expanded", Toast.LENGTH_SHORT).show();
                        return true;
                    }

                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem menuItem) {
                        Toast.makeText(RoomActivity.this, "Action View Collapsed", Toast.LENGTH_SHORT).show();
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
        ArrayList<UserModel> searchArraylist = new ArrayList<>();


        for (int i = 0; i < RoomReadUserFragment.getUserModelArrayList().size(); i++) {
            if (RoomReadUserFragment.getUserModelArrayList().get(i).getName().toLowerCase().contains(usertext)
                    || RoomReadUserFragment.getUserModelArrayList().get(i).getEmail().toLowerCase().contains(usertext)
                    || RoomReadUserFragment.getUserModelArrayList().get(i).getPhoneNo().toLowerCase().contains(usertext)
                    || RoomReadUserFragment.getUserModelArrayList().get(i).getLastName().toLowerCase().toLowerCase().contains(usertext)) {
                searchArraylist.add(RoomReadUserFragment.getUserModelArrayList().get(i));
            }

        }
        Log.e("DOST1", RoomReadUserFragment.getUserModelArrayList()+ "");
        Log.e("DOST2", searchArraylist + "");
        RoomReadUserFragment.getRoomReadUserAdapter().updateList(searchArraylist);

        return true;
    }


    public class MyAsynctask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            start_time = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                UserModel userModel = new UserModel();
                // userModel.setId(id + i);
                userModel.setName(randomSting());
                userModel.setLastName(randomSting());
                userModel.setPhoneNo(randomNumber());
                userModel.setEmail(randomSting().concat(randomComDomain()));
                RoomActivity.myAppDatabase.mydataAccessObject().addUser(userModel);
            }
            progressDialog.dismiss();
            end_time = System.currentTimeMillis();
            total_time = end_time - start_time;

            return null;
        }

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Please wait Data inserted..");
            progressDialog.show();
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            progressDialog.dismiss();
            Toast.makeText(RoomActivity.this, total_time + " mili seconds", Toast.LENGTH_SHORT).show();
            Toast.makeText(RoomActivity.this, "Insert Successfully", Toast.LENGTH_SHORT).show();
            super.onPostExecute(aVoid);
        }
    }
}
