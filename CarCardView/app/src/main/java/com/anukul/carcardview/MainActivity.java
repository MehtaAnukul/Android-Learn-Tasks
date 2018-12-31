package com.anukul.carcardview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rowRecyclerView;
    private RecyclerView customRecyclerView;
    private RowAdapter rowAdapter;
    private CarCustomAdapter carCustomAdapter;
    private ArrayList<RowModel> rowModelArrayList;
    private ArrayList<CarCustomModel> carCustomModelArrayList;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rowRecyclerView = findViewById(R.id.activity_main_rowRecyclerView);
        customRecyclerView = findViewById(R.id.activity_main_customRecyclerView);

        //row layout
         rowModelArrayList = new ArrayList<>();
         rowModelArrayList.add(new RowModel("Welcome Back"));

         rowAdapter = new RowAdapter(rowModelArrayList);

         RecyclerView.LayoutManager rowlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
         rowRecyclerView.setLayoutManager(rowlayoutManager);
         rowRecyclerView.setAdapter(rowAdapter);

         //custom layput
         carCustomModelArrayList = new ArrayList<>();
         carCustomModelArrayList.add(new CarCustomModel("Mclaren P1 LM","$3.7 million"));
         carCustomModelArrayList.add(new CarCustomModel("Lykan Hypersport","$3.4 million"));
         carCustomModelArrayList.add(new CarCustomModel("Lamborghini Veneno Roadster","$3.3 million"));
         carCustomModelArrayList.add(new CarCustomModel("Aston Martin Valkyrie","$3 million"));
         carCustomModelArrayList.add(new CarCustomModel("Ferrari Pininforina Sergio","$3 million"));
         carCustomModelArrayList.add(new CarCustomModel("Panani Huayra BC","$2.8 million"));

         carCustomAdapter = new CarCustomAdapter(carCustomModelArrayList);

         RecyclerView.LayoutManager customlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
         customRecyclerView.setLayoutManager(customlayoutManager);
         customRecyclerView.setAdapter(carCustomAdapter);

    }
}
