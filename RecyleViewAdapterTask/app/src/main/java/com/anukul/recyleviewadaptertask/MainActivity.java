package com.anukul.recyleviewadaptertask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rowRecyclerView;
    private RecyclerView customRecyleView;
    private ArrayList<UserModel> userModelArrayList;
    private UserAdapter userRowAdapter;
    private UserCustomAdapter userCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowRecyclerView.findViewById(R.id.activity_main_rowRecycleView);
        customRecyleView.findViewById(R.id.activity_main_customRecycleView);

        //Row_layout
        userModelArrayList = new ArrayList<>();
        userModelArrayList.add(new UserModel("Anukul"));
        userModelArrayList.add(new UserModel("Rahul"));
        userModelArrayList.add(new UserModel("Shreya"));
        userModelArrayList.add(new UserModel("Jeel"));
        userModelArrayList.add(new UserModel("ARSJ"));

        userRowAdapter = new UserAdapter(userModelArrayList);

        RecyclerView.LayoutManager rowlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        rowRecyclerView.setLayoutManager(rowlayoutManager);
        rowRecyclerView.setAdapter(userRowAdapter);

        //custom_layout
        userModelArrayList = new ArrayList<>();
        userModelArrayList.add(new UserModel("Anukul"));
        userModelArrayList.add(new UserModel("Rahul"));
        userModelArrayList.add(new UserModel("Shreya"));
        userModelArrayList.add(new UserModel("Jeel"));
        userModelArrayList.add(new UserModel("ARSJ"));

        userCustomAdapter = new UserCustomAdapter(userModelArrayList);

        RecyclerView.LayoutManager customlayoutManager = new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false);
        customRecyleView.setLayoutManager(customlayoutManager);
        customRecyleView.setAdapter(userCustomAdapter);
    }
}
