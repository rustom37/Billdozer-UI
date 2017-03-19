package com.example.user.myapplication;

/**
 * Created by User on 3/19/2017.
 */
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

public class TabFragment2 extends Fragment implements View.OnClickListener{

    ImageButton b1, b2, b3, b4;
    OnFragmentButtonClick fragmentButtonClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.tab_fragment_2, container, false);

        b1 = (ImageButton)view.findViewById(R.id.education_btn);
        b1.setOnClickListener(this);
        b2 = (ImageButton)view.findViewById(R.id.car_btn);
        b2.setOnClickListener(this);
        b3 = (ImageButton)view.findViewById(R.id.entertainment_btn);
        b3.setOnClickListener(this);
        b4 = (ImageButton)view.findViewById(R.id.addnew_btn);
        b4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) { //Have bug here

        switch (v.getId())
        {
            case R.id.education_btn:
                b1.setImageResource(R.drawable.green_education);
                fragmentButtonClick.onFragmentChoose("education");
                break;

            case R.id.car_btn:
                b2.setImageResource(R.drawable.green_car);
                fragmentButtonClick.onFragmentChoose("car");
                break;

            case R.id.entertainment_btn:
                b3.setImageResource(R.drawable.green_entertainment);
                fragmentButtonClick.onFragmentChoose("entertainment");
                break;

            case R.id.addnew_btn:
                b4.setImageResource(R.drawable.green_new);
                fragmentButtonClick.onFragmentChoose("addnew");
                break;
        }
    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        fragmentButtonClick = (OnFragmentButtonClick) context;
    }
}