package com.anukul.notesrecycleviewtask.activity;

        import android.content.DialogInterface;
        import android.content.Intent;
        import android.support.design.widget.FloatingActionButton;
        import android.support.v7.app.AlertDialog;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.PopupMenu;
        import android.widget.Toast;

        import com.anukul.notesrecycleviewtask.R;
        import com.anukul.notesrecycleviewtask.adapter.NotesCustomAdapter;
        import com.anukul.notesrecycleviewtask.app.AppConstant;
        import com.anukul.notesrecycleviewtask.listener.ItemClickListener;
        import com.anukul.notesrecycleviewtask.model.NotesModel;

        import java.util.ArrayList;

public class NotesViewActivity extends AppCompatActivity implements View.OnClickListener ,ItemClickListener {
    private static final String TAG = NotesViewActivity.class.getSimpleName();
    private RecyclerView notesCustomRecyclerView;
    private ArrayList<NotesModel> notesModelArrayList;
    private NotesCustomAdapter notesCustomAdapter;

    private FloatingActionButton floatingActionBtn;

    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes_view);

        notesCustomRecyclerView = findViewById(R.id.activity_notes_view_notesCustomRecyclerView);
        floatingActionBtn = findViewById(R.id.activity_notes_view_floatingActionBtn);

        notesModelArrayList = new ArrayList<>();
        notesCustomAdapter = new NotesCustomAdapter(notesModelArrayList,this);

        RecyclerView.LayoutManager notesCustomlayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        notesCustomRecyclerView.setLayoutManager(notesCustomlayoutManager);
        notesCustomRecyclerView.setAdapter(notesCustomAdapter);

        floatingActionBtn.setOnClickListener(this);
        intent = getIntent();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_notes_view_floatingActionBtn:
                gotoInsertNotesDataActivity();
                break;
        }
    }

    private void gotoInsertNotesDataActivity() {
        Intent gotoInsertNotesDataActivity = new Intent(NotesViewActivity.this,InsertNotesDataActivity.class);
        gotoInsertNotesDataActivity.putExtra(AppConstant.KEY_CODE,false);
        startActivityForResult(gotoInsertNotesDataActivity,100);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            if (resultCode == RESULT_OK){
                if(data != null){
                    final boolean status = intent.getBooleanExtra(AppConstant.KEY_CODE,false);
                    if (status){
                        final String title = data.getStringExtra(AppConstant.KEY_title);
                        final String category = data.getStringExtra(AppConstant.KEY_category);
                        final String details = data.getStringExtra(AppConstant.KEY_dateils);

                        NotesModel notesModel = new NotesModel(title,category,details);
                        int position = intent.getIntExtra(AppConstant.KEY_UPDATE_POSITION,200);
                        Log.e(TAG,"onActivityResult" +status +position);

                        notesModelArrayList.set(position,notesModel);
                        notesCustomAdapter.notifyDataSetChanged();

                    }else {
                        final String title = data.getStringExtra(AppConstant.KEY_title);
                        final String category = data.getStringExtra(AppConstant.KEY_category);
                        final String details = data.getStringExtra(AppConstant.KEY_dateils);

                        NotesModel notesModel = new NotesModel(title,category,details);
                        notesModelArrayList.add(notesModel);
                        notesCustomAdapter.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    //NotesCustom card optiom menu (update,delete)
    @Override
    public void onItemClick(NotesModel notesModel, View view, final int position) {
        PopupMenu popupMenu = new PopupMenu(this,view);
        getMenuInflater().inflate(R.menu.custom_option_menu,popupMenu.getMenu());
        popupMenu.show();

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.custom_option_menu_update:
                        updateData(position);
                        break;
                    case R.id.custom_option_menu_delete:
                        deleteData(position);
                        break;
                }
                return false;
            }

            private void deleteData(final int position) {
                AlertDialog.Builder builder = new AlertDialog.Builder(NotesViewActivity.this,R.style.Theme_AppCompat_Light_Dialog_MinWidth);
                builder.setTitle("DELETE");
                builder.setMessage("Are you sure ?");
                builder.setCancelable(false);

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(NotesViewActivity.this, "Notes Deleted", Toast.LENGTH_SHORT).show();
                        notesModelArrayList.remove(position);
                        notesCustomAdapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(NotesViewActivity.this, "Notes Not Deleted", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            private void updateData(int position) {
                Intent updateIntent = new Intent(NotesViewActivity.this,InsertNotesDataActivity.class);
                updateIntent.putExtra(AppConstant.KEY_CODE,true);
                updateIntent.putExtra(AppConstant.KEY_UPDATE_POSITION,position);
                startActivityForResult(updateIntent,300);
            }
        });
    }
}
