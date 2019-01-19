package com.anukul.recycleviewcardviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rowRecyclerView;
    private RecyclerView customRecyclerView;
    private AlienwareNameRowAdapter alienwareNameRowAdapter;
    private AirlineNameCustomAdapter airlineNameCustomAdapter;
    private ArrayList<AirlineModel> airlineModelArrayList;
    private ArrayList<AlienwareModel> alienwareModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowRecyclerView = findViewById(R.id.activity_main_rowRecycleView);
        customRecyclerView = findViewById(R.id.activity_main_customRecycleView);

        //row layout
        alienwareModelArrayList = new ArrayList<>();
        alienwareModelArrayList.add(new AlienwareModel("Aurora R5"));
        alienwareModelArrayList.add(new AlienwareModel("Alienware 15 R3"));
        alienwareModelArrayList.add(new AlienwareModel("Alienware 15 R4"));
        alienwareModelArrayList.add(new AlienwareModel("Alienware 17 R5"));
        alienwareModelArrayList.add(new AlienwareModel("Alienware 17"));
        alienwareModelArrayList.add(new AlienwareModel("Alienware 13 OLED"));

        alienwareNameRowAdapter = new AlienwareNameRowAdapter(alienwareModelArrayList);

        RecyclerView.LayoutManager rowlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rowRecyclerView.setLayoutManager(rowlayoutManager);
        rowRecyclerView.setAdapter(alienwareNameRowAdapter);

        //custom layout
        airlineModelArrayList = new ArrayList<>();
        airlineModelArrayList.add(new AirlineModel("Jet Airways(9W)",R.drawable.airlines));
        airlineModelArrayList.add(new AirlineModel("Indigo(6E)",R.drawable.alienware));
        airlineModelArrayList.add(new AirlineModel("Air India(AI)",R.drawable.sydney_airport));
//        airlineModelArrayList.add(new AirlineModel("SpiceJet(SG)"));
//        airlineModelArrayList.add(new AirlineModel("GoAir(G8)"));
//        airlineModelArrayList.add(new AirlineModel("Qatar Airways(QR)"));


        airlineNameCustomAdapter = new AirlineNameCustomAdapter(airlineModelArrayList);

        RecyclerView.LayoutManager customlayoutManager = new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false);
        customRecyclerView.setLayoutManager(customlayoutManager);
        customRecyclerView.setAdapter(airlineNameCustomAdapter);

    }
}
