package com.anukul.travelstreamcardview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {
    private RecyclerView customRecyclerView;
    private TravelBeacheAdapter travelBeacheAdapter;
    private ArrayList<TravelBeacheModel> travelBeacheModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customRecyclerView = findViewById(R.id.activity_main_customRecyclerView);

        travelBeacheModelArrayList = new ArrayList<>();
        travelBeacheModelArrayList.add(new TravelBeacheModel("Bondi Beach", "Number 10", "Bondi Beach", "Sydney NSW",R.drawable.bondi_beach10));
        travelBeacheModelArrayList.add(new TravelBeacheModel("Lizard Island QLD", "Number 9", "Lizard Island QLD", "Near Cairns,For North Queensland",R.drawable.lizard_island9));
        travelBeacheModelArrayList.add(new TravelBeacheModel("Main Beach,Byron Bay NSW", "Number 8", "Main Beach,Byron Bay NSW", "Parkyn Parade,Mooloolaba",R.drawable.byron_bay_beac8));
        travelBeacheModelArrayList.add(new TravelBeacheModel("Mandalay Beach", "Number 7", "Mandalay Beach", "Walpole WA",R.drawable.mandalay_beach7));
        travelBeacheModelArrayList.add(new TravelBeacheModel("Wineglass Bay", "Number 6", "Wineglass Bay", "Freycinet National Park TAS",R.drawable.wineglass_beach6));
        travelBeacheModelArrayList.add(new TravelBeacheModel("75Mile Beach", "Number 5", "75Mile Beach", "Fraser Island QLD",R.drawable.mile75_beach_fraserisland5));

        travelBeacheAdapter = new TravelBeacheAdapter(travelBeacheModelArrayList,this);

        RecyclerView.LayoutManager customLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        customRecyclerView.setLayoutManager(customLayoutManager);
        customRecyclerView.setAdapter(travelBeacheAdapter);

    }


    @Override
    public void onItemClick(TravelBeacheModel travelBeacheModel) {
        Toast.makeText(this, ""+travelBeacheModel.getNameOfBeache(), Toast.LENGTH_SHORT).show();
    }
}
