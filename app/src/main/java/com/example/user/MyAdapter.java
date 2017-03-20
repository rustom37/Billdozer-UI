package com.example.user.myapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by User on 3/18/2017.
 */

class MyAdapter extends ArrayAdapter<String> {
    int[] transAmount;
    Integer[]imgId;

    public MyAdapter(Context context, String[] values, int[]trans, Integer[] imgid)
    {
        super(context,R.layout.row_layout_2,values);
        transAmount = trans;
        imgId = imgid;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater theInflater = LayoutInflater.from(getContext());

        View theView = theInflater.inflate(R.layout.row_layout_2,parent,false);

        String categoryName = getItem(position);

        TextView theTextView = (TextView)theView.findViewById(R.id.TextView1);

        theTextView.setText(categoryName);


        ImageView theImageView = (ImageView)theView.findViewById(R.id.imageView1);

        theImageView.setImageResource(imgId[position]);

        TextView theTextView1 = (TextView)theView.findViewById(R.id.TextView2);

        theTextView1.setText(transAmount[position]+"L.L.");

        return theView;
    }
}
