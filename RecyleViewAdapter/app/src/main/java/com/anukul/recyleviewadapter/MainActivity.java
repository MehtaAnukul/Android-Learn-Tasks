package com.anukul.recyleviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<UserModel> userModelArrayList;
    private UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.activity_main_user_recycleView);

        userModelArrayList = new ArrayList<>();

        userModelArrayList.add(new UserModel("Anukul","anukul@gmail.com","12:00"));
        userModelArrayList.add(new UserModel("Rahul","rahul@gmail.com","12:00"));
        userModelArrayList.add(new UserModel("Vishal","vishal@gmail.com","12:00"));
        userModelArrayList.add(new UserModel("Mimoh","mimoh@gmail.com","12:00"));
        userModelArrayList.add(new UserModel("Dhananjay","dhananjay@gmail.com","12:00"));
        userModelArrayList.add(new UserModel("Karan","karan@gmail.com","12:00"));
        userModelArrayList.add(new UserModel("Het","het@gmail.com","12:00"));


        userAdapter = new UserAdapter(userModelArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);

    }
}
