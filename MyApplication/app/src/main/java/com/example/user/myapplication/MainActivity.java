package com.example.user.myapplication;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabSelectedListener;

public class MainActivity extends AppCompatActivity {

    BottomBar mbottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbottomBar = BottomBar.attach(this,savedInstanceState);
        mbottomBar.setItemsFromMenu(R.menu.menu_main, new OnMenuTabSelectedListener() {
            @Override
            public void onMenuItemSelected(@IdRes int i) {
               if(i==R.id.bottombaritem_transactions)
               {
                   TransactionFragment f = new TransactionFragment();
                   getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
               }
                if(i==R.id.bottombaritemtwo)
                {
                    Cardsfragment f = new Cardsfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                if(i==R.id.bottombaritemthree)
                {
                    Phonefragment f = new Phonefragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                if(i==R.id.bottombaritemfour)
                {
                    Mailsfragment f = new Mailsfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
                if(i==R.id.bottombaritemfive)
                {
                    Favoritesfragment f = new Favoritesfragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame,f).commit();
                }
            }
        });

    }
}