package com.anukul.listspinneradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner stateSpinner;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> stringStateArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        stateSpinner = findViewById(R.id.activity_state_spinner);

        stringStateArrayList = new ArrayList<>();
        stringStateArrayList.add("Jammu & kashmir");
        stringStateArrayList.add("Himanchal Pradesh");
        stringStateArrayList.add("Uttarachal");
        stringStateArrayList.add("Panjab");
        stringStateArrayList.add("Haryana");
        stringStateArrayList.add("Delhi");
        stringStateArrayList.add("Rajesthan");
        stringStateArrayList.add("Gujrat");
        stringStateArrayList.add("Maharastra");
        stringStateArrayList.add("Goa");
        stringStateArrayList.add("Karnataka");
        stringStateArrayList.add("Kerala");
        stringStateArrayList.add("Tamilnadu");
        stringStateArrayList.add("Pondicherry");
        stringStateArrayList.add("Andhra Pradesh");
        stringStateArrayList.add("Madhya Pradesh");
        stringStateArrayList.add("Uttar Pradesh");
        stringStateArrayList.add("Bihar");
        stringStateArrayList.add("Jharkhand");
        stringStateArrayList.add("Chhattisgath");
        stringStateArrayList.add("Orrisa");



        arrayAdapter = new ArrayAdapter<>(this,R.layout.stateofindia_name,R.id.stateofindia_name_Tv,stringStateArrayList);
        stateSpinner.setAdapter(arrayAdapter);
    }
}
