package com.anukul.profilerecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView customRecyclerView;
    private ProfileCustomAdapter profileCustomAdapter;
    private ArrayList<ProfileModel> profileModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customRecyclerView = findViewById(R.id.activity_main_customRecyclerView);

        profileModelArrayList = new ArrayList<>();
        profileModelArrayList.add(new ProfileModel("Mimoh", "mimoh@gmail.com", R.drawable.man));
        profileModelArrayList.add(new ProfileModel("Rahul", "rahul@gmail.com", R.drawable.man));
        profileModelArrayList.add(new ProfileModel("het", "het@gmail.com", R.drawable.man));
        profileModelArrayList.add(new ProfileModel("Anukul", "anukul@gmail.com", R.drawable.man));

        profileCustomAdapter = new ProfileCustomAdapter(profileModelArrayList, this);

        RecyclerView.LayoutManager customlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        customRecyclerView.addItemDecoration(itemDecoration);
        customRecyclerView.setLayoutManager(customlayoutManager);
        customRecyclerView.setAdapter(profileCustomAdapter);

    }

    @Override
    public void onItemClick(ProfileModel profileModel) {
        Toast.makeText(this, "" + profileModel.getEmail(), Toast.LENGTH_SHORT).show();

    }
}
