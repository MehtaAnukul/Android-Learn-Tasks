package com.anukul.mainrecyclerviewtask.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;

import com.anukul.mainrecyclerviewtask.Listener.ItemClickListener;
import com.anukul.mainrecyclerviewtask.R;
import com.anukul.mainrecyclerviewtask.Adapter.UserCustomAdapter;
import com.anukul.mainrecyclerviewtask.Model.UserModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ItemClickListener {

    private TextView evenTv;
    private TextView oddTv;
    private FloatingActionButton floatingActionPlusBtn;
    private RecyclerView customRecyclerView;
    private UserCustomAdapter userCustomAdapter;
    private ArrayList<UserModel> userModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        evenTv = findViewById(R.id.activity_main_evenTv);
        oddTv = findViewById(R.id.activity_main_oddTv);
        floatingActionPlusBtn = findViewById(R.id.activity_main_floatingActionPlusBtn);

        customRecyclerView = findViewById(R.id.activity_main_customRecyclerView);

        floatingActionPlusBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_floatingActionPlusBtn:
                gotoSecondActivity();
        }
    }

    private void gotoSecondActivity() {
        Intent gotoSecondActivtyIntent = new Intent(this, InsertDataActivity.class);
        startActivityForResult(gotoSecondActivtyIntent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    data.getStringExtra("KAY_NAME");
                    data.getStringExtra("KAY_DETAILS");


                }
            }
        }
    }


    //color optionMenu

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.seekbar_layout_colorSeekbar:
                openCustomDialog();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openCustomDialog() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);
        appCompatDialog.setContentView(R.layout.seekbar_layout);
        appCompatDialog.setTitle("Seekbar");
        appCompatDialog.show();
        //appCompatDialog.dismiss();
    }


    @Override
    public void onItemClick(UserModel userModel, View view) {

        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        getMenuInflater().inflate(R.menu.data_menu, popupMenu.getMenu());
        popupMenu.show();

    }
}
