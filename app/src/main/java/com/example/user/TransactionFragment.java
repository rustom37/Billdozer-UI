package com.example.user.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by User on 3/18/2017.
 */

public class TransactionFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.transaction_layout,container,false);

        String[] categoryNames = {"Shopping","Entertainment"};
        Integer[] imgid = {R.drawable.shopping_cart_icon,R.drawable.entertainment_ic};
        int[] transAmount = {-45000,-30000};

        int total = 0;
        for(int i = 0; i<transAmount.length;i++)
        {
            total+=transAmount[i];
        }
        String totalE = total+"L.L.";
        TextView totalExpensesToday = (TextView)v.findViewById(R.id.totalExpenesesToday) ;
        totalExpensesToday.setText(totalE);
        TextView totalExpenses = (TextView)v.findViewById(R.id.totalExpenses) ;
        totalExpenses.setText(totalE);

        ListAdapter theAdapater = new MyAdapter(getActivity(), categoryNames,transAmount,imgid);

        ListView theListView = (ListView)v.findViewById(R.id.theListView);


        theListView.setAdapter(theAdapater);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent addTransaction = new Intent(getActivity(),AddActivity.class);
                startActivity(addTransaction);
            }
        });
        return v;
    }

}
