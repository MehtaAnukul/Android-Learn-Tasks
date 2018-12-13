package com.anukul.listspinneradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    private ListView personNameListView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> stringArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        personNameListView = findViewById(R.id.activity_main_listView);

        stringArrayList = new ArrayList<>();
        stringArrayList.add("Mimoh");
        stringArrayList.add("Dhananjay");
        stringArrayList.add("Karan");
        stringArrayList.add("Vishal");
        stringArrayList.add("Rahul");

        arrayAdapter = new ArrayAdapter<>(this,R.layout.person_name_icon,R.id.person_name_icon_Tv,stringArrayList);

        personNameListView.setAdapter(arrayAdapter);
    }
}
