package com.anukul.listspinneradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner citySpinner;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> stringCityArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        citySpinner = findViewById(R.id.activity_city_spinner);

        stringCityArrayList = new ArrayList<>();
        stringCityArrayList.add("Delhi");
        stringCityArrayList.add("Mumbai");


        arrayAdapter = new ArrayAdapter<>(this,R.layout.city_name,R.id.city_name_Tv,stringCityArrayList);
        citySpinner.setAdapter(arrayAdapter);
    }
}
