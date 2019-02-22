package com.anukul.sqlitevsroomtest.roomfragment;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.anukul.sqlitevsroomtest.R;
import com.anukul.sqlitevsroomtest.roomAdapter.RoomReadUserAdapter;
import com.anukul.sqlitevsroomtest.roomModel.UserModel;
import com.anukul.sqlitevsroomtest.sqlite.RoomActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoomReadUserFragment extends Fragment implements View.OnClickListener{
    private RecyclerView customReadUserRecyclerView;

    private static ArrayList<UserModel> userModelArrayList;
    private static RoomReadUserAdapter roomReadUserAdapter;

    private FloatingActionButton floatingActionButton;
    private FloatingActionButton fFloatingActionButton;
    private FloatingActionButton lFloatingActionButton;
    private FloatingActionButton emailfloatingActionButton;

    private boolean fabExpanded = false;

    private LinearLayout firstNameFabLayout;
    private LinearLayout lastNameFabLayout;
    private LinearLayout emailFabLayout;

    public RoomReadUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_room_read_user, container, false);

        customReadUserRecyclerView = view.findViewById(R.id.fragment_roomReadUser_recyclerView);
        floatingActionButton = view.findViewById(R.id.roomList_sort);
        fFloatingActionButton = view.findViewById(R.id.firstName_floatingBtn);
        lFloatingActionButton = view.findViewById(R.id.lastName_floatingBtn);
        emailfloatingActionButton = view.findViewById(R.id.email_floatingBtn);

        firstNameFabLayout = view.findViewById(R.id.fab_firstName_layout);
        lastNameFabLayout = view.findViewById(R.id.fab_lastname_layout);
        emailFabLayout = view.findViewById(R.id.fab_email_layout);

        userModelArrayList = (ArrayList<UserModel>) RoomActivity.myAppDatabase.mydataAccessObject().getUsers();

        roomReadUserAdapter  = new RoomReadUserAdapter(userModelArrayList);

        firstNameFabLayout.setVisibility(View.INVISIBLE);
        lastNameFabLayout.setVisibility(View.INVISIBLE);
        emailFabLayout.setVisibility(View.INVISIBLE);

       floatingActionButton.setOnClickListener(this);
       fFloatingActionButton.setOnClickListener(this);
       lFloatingActionButton.setOnClickListener(this);
       emailfloatingActionButton.setOnClickListener(this);
        /*floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.sort(userModelArrayList, new Comparator<UserModel>() {
                    @Override
                    public int compare(UserModel userModel, UserModel t1) {
                        String item1 = userModel.getName();
                        String item2 = t1.getName();
                        return item1.compareTo(item2);
                    }
                });
                roomReadUserAdapter.notifyDataSetChanged();
            }
        });*/

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        customReadUserRecyclerView.setLayoutManager(layoutManager);
        customReadUserRecyclerView.setAdapter(roomReadUserAdapter);

        if (userModelArrayList.size() == 0){
            Toast.makeText(getActivity(),"No Data", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), "View Success", Toast.LENGTH_SHORT).show();
        return view;
    }

    public static ArrayList<UserModel> getUserModelArrayList() {
        return userModelArrayList;
    }

    public static RoomReadUserAdapter getRoomReadUserAdapter() {
        return roomReadUserAdapter;
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()){
           case R.id.roomList_sort:
               if (fabExpanded){
                   closeSubMenusFab();
               }else {
                   openSubMenusFab();
               }
               break;
           case R.id.firstName_floatingBtn:
               Collections.sort(userModelArrayList, new Comparator<UserModel>() {
                   @Override
                   public int compare(UserModel userModel, UserModel t1) {
                       String item1 = userModel.getName();
                       String item2 = t1.getName();
                       return item1.compareTo(item2);
                   }
               });
               roomReadUserAdapter.notifyDataSetChanged();
               break;
           case R.id.lastName_floatingBtn:
               Collections.sort(userModelArrayList, new Comparator<UserModel>() {
                   @Override
                   public int compare(UserModel userModel, UserModel t1) {
                       String item1 = userModel.getLastName();
                       String item2 = t1.getLastName();
                       return item1.compareTo(item2);
                   }
               });
               roomReadUserAdapter.notifyDataSetChanged();
               break;
           case R.id.email_floatingBtn:
               Collections.sort(userModelArrayList, new Comparator<UserModel>() {
                   @Override
                   public int compare(UserModel userModel, UserModel t1) {
                       String item1 = userModel.getEmail();
                       String item2 = t1.getEmail();
                       return item1.compareTo(item2);
                   }
               });
               roomReadUserAdapter.notifyDataSetChanged();
               break;
       }
    }

    private void openSubMenusFab() {
        firstNameFabLayout.setVisibility(View.VISIBLE);
        lastNameFabLayout.setVisibility(View.VISIBLE);
        emailFabLayout.setVisibility(View.VISIBLE);
        floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_close));
        fabExpanded = true;
    }

    private void closeSubMenusFab() {
        firstNameFabLayout.setVisibility(View.INVISIBLE);
        lastNameFabLayout.setVisibility(View.INVISIBLE);
        emailFabLayout.setVisibility(View.INVISIBLE);
        floatingActionButton.setImageDrawable(getResources().getDrawable(R.drawable.ic_sort_black_24dp));
        fabExpanded = false;
    }

}
