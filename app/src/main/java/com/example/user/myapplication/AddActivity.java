package com.example.user.myapplication;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

/**
 * Created by User on 3/19/2017.
 */

public class AddActivity extends FragmentActivity implements View.OnClickListener, OnFragmentButtonClick{

    private static int currentpage = 0;
    ImageButton datePicker, deleteBtn;
    EditText txtDate, descrip, amount;
    ToggleButton btn;
    TextView text;
    ImageView img;
    Button button, b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, decimalBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_reports);

        datePicker = (ImageButton) findViewById(R.id.calendaricon);
        txtDate = (EditText) findViewById(R.id.in_date);
        descrip = (EditText) findViewById(R.id.in_description);
        btn = (ToggleButton) findViewById(R.id.toggleButton);
        text = (TextView) findViewById(R.id.textView);
        img = (ImageView) findViewById(R.id.boxicon);
        button = (Button) findViewById(R.id.button);
        deleteBtn = (ImageButton) findViewById(R.id.button_delete);
        amount = (EditText) findViewById(R.id.editText);
        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);
        b5 = (Button) findViewById(R.id.button5);
        b6 = (Button) findViewById(R.id.button6);
        b7 = (Button) findViewById(R.id.button7);
        b8 = (Button) findViewById(R.id.button8);
        b9 = (Button) findViewById(R.id.button9);
        b0 = (Button) findViewById(R.id.button0);
        decimalBtn = (Button) findViewById(R.id.button_decimal);

        datePicker.setOnClickListener(this);
        txtDate.setOnClickListener(this);
        button.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b5.setOnClickListener(this);
        b4.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);
        b0.setOnClickListener(this);
        decimalBtn.setOnClickListener(this);

        // Layout manager that allows the user to flip through the pages
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // getSupportFragmentManager allows use to interact with the fragments
        // MyFragmentPagerAdapter will return a fragment based on an index that is passed
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                AddActivity.this));





    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick (View v){

        if (v == datePicker || v == txtDate) {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                }
            }, year, month, day);
            datePickerDialog.show();
        }

        if (v == b0) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "0");
        }

        if (v == b1) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "1");
        }

        if (v == b2) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "2");
        }

        if (v == b3) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "3");
        }

        if (v == b4) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "4");
        }

        if (v == b5) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "5");
        }

        if (v == b6) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "6");
        }

        if (v == b7) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "7");
        }

        if (v == b8) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "8");
        }

        if (v == b9) {
            Editable s = amount.getText();
            amount.setText(s.toString() + "9");
        }

        if (v == deleteBtn) {
            if(amount.getText().toString().equals("")) {
                amount.setText("");
            }
            else
            {
                amount.setText(amount.getText().delete(amount.getText().length() - 1, amount.getText().length()));
            }

        }

        if (v == decimalBtn) {
            Editable s = amount.getText();
            amount.setText(s.toString() + ".");
        }


        if (v == button) {
            double d = Double.parseDouble(amount.getText().toString());
        }
    }
    @Override
    public void onFragmentChoose (String category){ //HAVING PROBLEM HERE
        if (category.equals("food")) {
            text.setText("Food");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.food_logo);
        } else if (category.equals("shopping")) {
            text.setText("Shopping");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.shopping_logo);
        } else if (category.equals("healthcare")) {
            text.setText("Healthcare");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.healthcare_logo);
        } else if (category.equals("home")) {
            text.setText("Home");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.home_logo);
        } else if (category.equals("travel")) {
            text.setText("Travel");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.travel_logo);
        } else if (category.equals("family")) {
            text.setText("Family");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.family_logo);
        } else if (category.equals("groceries")) {
            text.setText("Groceries");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.groceries_logo);
        } else if (category.equals("bills")) {
            text.setText("Bills");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.bills_logo);
        } else if (category.equals("education")) {
            text.setText("Education");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.education_logo);
        } else if (category.equals("car")) {
            text.setText("Car");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.car_logo);
        } else if (category.equals("entertainment")) {
            text.setText("Entertainment");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.entertainment_logo);
        } else if (category.equals("addnew")) {
            text.setText("New Category");
            text.setTextColor(Color.parseColor("#951b81"));
            img.setImageResource(R.drawable.addnew_logo);
        }
    }
}