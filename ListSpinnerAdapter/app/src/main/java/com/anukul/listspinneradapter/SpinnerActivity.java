package com.anukul.listspinneradapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;

public class SpinnerActivity extends AppCompatActivity {
    private Spinner stateSpinner;
    private Spinner citySpinner;
    ArrayAdapter<String> stateAdapter;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> stringStateArrayList;
    ArrayList<String> stringCityArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        stateSpinner = findViewById(R.id.activity_state_spinner);
        citySpinner = findViewById(R.id.activity_city_spinner);
        //State of India
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
        stateAdapter = new ArrayAdapter<>(this,R.layout.stateofindia_name,R.id.stateofindia_name_Tv,stringStateArrayList);
        stateSpinner.setAdapter(stateAdapter);

        //City of Gujarat
        stringCityArrayList = new ArrayList<>();
        stringCityArrayList.add("Gandhinagar");
        stringCityArrayList.add("Himatnagar");
        stringCityArrayList.add("Vadodara ");
        stringCityArrayList.add("Surat");
        stringCityArrayList.add("Rajkot ");
        stringCityArrayList.add("Junagadh");
        stringCityArrayList.add("Surendranagar");
        stringCityArrayList.add("Bhavnagar ");
        stringCityArrayList.add("Jamnagar");
        stringCityArrayList.add("Mehsana");
        stringCityArrayList.add("Palitana");
        stringCityArrayList.add("Visnagar");
        stringCityArrayList.add("Saputara");
        stringCityArrayList.add("Patan");
        stringCityArrayList.add("Valsad");
        stringCityArrayList.add("Nadiad");
        stringCityArrayList.add("Anand");
        stringCityArrayList.add("Navsari");
        stringCityArrayList.add("Morvi");
        stringCityArrayList.add("Dahod ");
        stringCityArrayList.add("Balasinor");
        cityAdapter = new ArrayAdapter<>(this,R.layout.stateofindia_name,R.id.stateofindia_name_Tv,stringCityArrayList);
        citySpinner.setAdapter(cityAdapter);


    }
}
