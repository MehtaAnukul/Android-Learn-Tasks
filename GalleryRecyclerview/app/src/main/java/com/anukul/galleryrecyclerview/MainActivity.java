package com.anukul.galleryrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener{
    private RecyclerView galleryCustomlayout;
    private GalleryAdapter galleryAdapter;
    private ArrayList<GalleryModel> galleryModelArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        galleryCustomlayout = findViewById(R.id.activity_main_galleryCustomLayout);

        galleryModelArrayList = new ArrayList<>();
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));
        galleryModelArrayList.add(new GalleryModel("Oudi",R.drawable.lamborghini_huracan));


        galleryAdapter = new GalleryAdapter(galleryModelArrayList,this);

        RecyclerView.LayoutManager customlayoutManager = new GridLayoutManager(this,2,LinearLayoutManager.VERTICAL,false);
        galleryCustomlayout.setLayoutManager(customlayoutManager);
        galleryCustomlayout.setAdapter(galleryAdapter);
    }

    @Override
    public void onItemClick(GalleryModel galleryModel) {
        Toast.makeText(this, ""+galleryModel.getCarName(), Toast.LENGTH_SHORT).show();

    }
}
