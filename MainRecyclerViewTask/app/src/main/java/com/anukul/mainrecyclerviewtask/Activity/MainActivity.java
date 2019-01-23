package com.anukul.mainrecyclerviewtask.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.anukul.mainrecyclerviewtask.Adapter.UserCustomAdapter;
import com.anukul.mainrecyclerviewtask.App.AppConstant;
import com.anukul.mainrecyclerviewtask.Listener.ItemClickListener;
import com.anukul.mainrecyclerviewtask.Model.UserModel;
import com.anukul.mainrecyclerviewtask.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, ItemClickListener ,SeekBar.OnSeekBarChangeListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView evenTv;
    private TextView oddTv;
    private FloatingActionButton floatingActionPlusBtn;
    private RecyclerView customRecyclerView;
    private UserCustomAdapter userCustomAdapter;
    private ArrayList<UserModel> userModelArrayList;

    //colorPickerDialog
    private SeekBar colorRedSk;
    private SeekBar colorGreenSk;
    private SeekBar colorBlueSk;
    private SeekBar colorAlphaSk;
    RelativeLayout colorPreview;
    private Button okBtn;
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int alpha = 0;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        userModelArrayList = new ArrayList<>();
        userCustomAdapter = new UserCustomAdapter(this,userModelArrayList, this,Color.WHITE,Color.WHITE);

        RecyclerView.LayoutManager customlayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        customRecyclerView.setLayoutManager(customlayoutManager);
        customRecyclerView.setAdapter(userCustomAdapter);
    }

    private void initView() {
        evenTv = findViewById(R.id.activity_main_evenTv);
        oddTv = findViewById(R.id.activity_main_oddTv);
        floatingActionPlusBtn = findViewById(R.id.activity_main_floatingActionPlusBtn);

        customRecyclerView = findViewById(R.id.activity_main_customRecyclerView);

        evenTv.setOnClickListener(this);
        oddTv.setOnClickListener(this);
        floatingActionPlusBtn.setOnClickListener(this);
//        intent = getIntent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.activity_main_evenTv:
                changeColorOfEvenItems();
                break;
            case R.id.activity_main_oddTv:
                changeColorOfOddItems();
                break;
            case R.id.activity_main_floatingActionPlusBtn:
                gotoInsertDataActivity();
                break;
        }
    }

    private void changeColorOfOddItems() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this,R.style.Theme_AppCompat_Light_Dialog_MinWidth);
        appCompatDialog.setContentView(R.layout.colorpicker_dialog);
        appCompatDialog.setTitle("ColorPickerDialog");
        appCompatDialog.show();

        colorRedSk = appCompatDialog.findViewById(R.id.activity_colorpicker_redSeekbar);
        colorGreenSk = appCompatDialog.findViewById(R.id.activity_colorpicker_greenSeekbar);
        colorBlueSk = appCompatDialog.findViewById(R.id.activity_colorpicker_blueSeekbar);
        colorAlphaSk = appCompatDialog.findViewById(R.id.activity_colorpicker_alphaSeekbar);
        colorPreview = appCompatDialog.findViewById(R.id.activity_colorpicker_relativelayout);
        okBtn = appCompatDialog.findViewById(R.id.activity_colorpicker_okBtn);

        colorRedSk.setOnSeekBarChangeListener(this);
        colorGreenSk.setOnSeekBarChangeListener(this);
        colorBlueSk.setOnSeekBarChangeListener(this);
        colorAlphaSk.setOnSeekBarChangeListener(this);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appCompatDialog.dismiss();
                userCustomAdapter.changeEvenItemBackgroundColor(Color.argb(alpha,red,green,blue));
                userCustomAdapter.notifyDataSetChanged();
            }
        });

    }

    private void changeColorOfEvenItems() {
        final AppCompatDialog appCompatDialog = new AppCompatDialog(this,R.style.Theme_AppCompat_Light_Dialog_MinWidth);
        appCompatDialog.setContentView(R.layout.colorpicker_dialog);
        appCompatDialog.setTitle("ColorPickerDialog");
        appCompatDialog.show();

        colorRedSk = appCompatDialog.findViewById(R.id.activity_colorpicker_redSeekbar);
        colorGreenSk = appCompatDialog.findViewById(R.id.activity_colorpicker_greenSeekbar);
        colorBlueSk = appCompatDialog.findViewById(R.id.activity_colorpicker_blueSeekbar);
        colorAlphaSk = appCompatDialog.findViewById(R.id.activity_colorpicker_alphaSeekbar);
        colorPreview = appCompatDialog.findViewById(R.id.activity_colorpicker_relativelayout);
        okBtn = appCompatDialog.findViewById(R.id.activity_colorpicker_okBtn);

        colorRedSk.setOnSeekBarChangeListener(this);
        colorGreenSk.setOnSeekBarChangeListener(this);
        colorBlueSk.setOnSeekBarChangeListener(this);
        colorAlphaSk.setOnSeekBarChangeListener(this);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appCompatDialog.dismiss();
                userCustomAdapter.changeOddItemBackgroundColor(Color.argb(alpha,red,green,blue));
                userCustomAdapter.notifyDataSetChanged();
            }
        });




    }


    private void gotoInsertDataActivity() {
        Intent addIntent = new Intent(this, InsertDataActivity.class);
        addIntent.putExtra(AppConstant.KEY_CODE, false);
        startActivityForResult(addIntent, 100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100) {

            Log.e(TAG, "checkallData");

            if (resultCode == RESULT_OK) {

                Log.e(TAG, resultCode + "");

                if (data != null) {

                    final boolean status = data.getBooleanExtra(AppConstant.KEY_CODE, false);


                    if (status) {

                        final String name = data.getStringExtra(AppConstant.KEY_NAME);
                        final String date = data.getStringExtra(AppConstant.KEY_DATE);
                        final String details = data.getStringExtra(AppConstant.KEY_DETAILS);
                        UserModel userModel = new UserModel(name, date, details);
//                        int position = intent.getIntExtra(AppConstant.KEY_UPDATE_POSITION, 200);
                        int id = data.getIntExtra(AppConstant.KEY_UPDATE_POSITION, 200);

                        Log.e(TAG, "onActivityResult: " + status + id);
                        userModelArrayList.set(id, userModel);
                        userCustomAdapter.notifyDataSetChanged();

                    } else {

                        final String name = data.getStringExtra(AppConstant.KEY_NAME);
                        final String date = data.getStringExtra(AppConstant.KEY_DATE);
                        final String details = data.getStringExtra(AppConstant.KEY_DETAILS);
                        UserModel userModel = new UserModel(name, date, details);
                        userModelArrayList.add(userModel);
                        userCustomAdapter.notifyDataSetChanged();

                    }


                }
            }
        }
    }

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


    //Caustom card optiom menu (update,delete)
    @Override
    public void onItemClick(UserModel userModel, View view, final int position) {

        PopupMenu popupMenu = new PopupMenu(MainActivity.this, view);
        getMenuInflater().inflate(R.menu.custom_menu, popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.custom_menu_update:
                        Toast.makeText(MainActivity.this, "Update", Toast.LENGTH_SHORT).show();
                        updatedata(position);
                        break;
                    case R.id.custom_menu_delete:
                        deleteData(position);
                        break;
                }
                return false;
            }
        });


    }

    private void updatedata(int position) {
        Intent updateIntent = new Intent(this, InsertDataActivity.class);
        updateIntent.putExtra(AppConstant.KEY_CODE, true);
        updateIntent.putExtra(AppConstant.KEY_UPDATE_POSITION, position);

        startActivityForResult(updateIntent, 100);

    }

    private void deleteData(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.Theme_AppCompat_Light_Dialog_MinWidth);
        builder.setTitle("DELETE");
        builder.setMessage("Are you sure you want Delete");
        builder.setCancelable(false);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Card Deleted", Toast.LENGTH_SHORT).show();
                userModelArrayList.remove(position);
                userCustomAdapter.notifyDataSetChanged();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Card Not Deleted", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();
    }


    //ColorPickerDialog --> SeekBar Code
    //evenText , oddText
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        switch (seekBar.getId()){
            case R.id.activity_colorpicker_redSeekbar:
                Toast.makeText(this,"RED SEEKBAR",Toast.LENGTH_SHORT).show();
                red = progress;
                break;
            case R.id.activity_colorpicker_greenSeekbar:
                Toast.makeText(this,"GREEN SEEKBAR",Toast.LENGTH_SHORT).show();
                green = progress;
                break;
            case R.id.activity_colorpicker_blueSeekbar:
                Toast.makeText(this,"BLUE SEEKBAR",Toast.LENGTH_SHORT).show();
                blue = progress;
                break;
            case R.id.activity_colorpicker_alphaSeekbar:
                Toast.makeText(this,"ALPHA SEEKBAR",Toast.LENGTH_SHORT);
                alpha = progress;
                break;
        }
        colorPreview.setBackgroundColor(Color.argb(alpha,red,green,blue));

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
