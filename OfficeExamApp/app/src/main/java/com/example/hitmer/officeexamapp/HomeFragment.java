package com.example.hitmer.officeexamapp;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnsqlite,btnroom;
    OnDbOpListener dbOpListener;
    public HomeFragment() {
        // Required empty public constructor
    }
    public interface OnDbOpListener
    {
        public void dbOpPerformed(int method);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        btnsqlite = view.findViewById(R.id.btnSQLIte);
        btnsqlite.setOnClickListener(this);
        btnroom = view.findViewById(R.id.btnRoom);
        btnroom.setOnClickListener(this);

        return view;
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.btnSQLIte:
                dbOpListener.dbOpPerformed(0);
                break;

            case R.id.btnRoom:
                dbOpListener.dbOpPerformed(1);
                break;

//            case R.id.btnAdd:
//                dbOpListener.dbOpPerformed(2);
//                break;

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity)context;

        try{
            dbOpListener = (OnDbOpListener) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + "Must Override method");
        }
    }
}
