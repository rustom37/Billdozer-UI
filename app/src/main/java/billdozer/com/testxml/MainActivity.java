package billdozer.com.testxml;

import android.app.DatePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import io.github.kshitij_jain.indicatorview.IndicatorView;

import static billdozer.com.testxml.R.id.calendaricon;

/*
Fragments make it easy to create interfaces that work on different
screen sizes. They do this by breaking different parts of your
interface into fragments. Activities can then decide which fragments
to use and where to put them based on screen size or orientation.
It is also nice to use the same fragment on multiple activities.
If your app is running on a phone you should have a single fragment
normally and as the screen size increases you can add more.
Version 3.0 is required to use fragments unless you use a support
library. You cannot use the PreferenceFragment class unless you
use API 11 or higher though. You install the support library in the
SDK Manager. Look in the Extras folder. The location of the jar file
is /sdk/extras/android/support/v4/android-support-v4.jar ( Save it in
your libs folder )
 */

public class MainActivity extends FragmentActivity implements View.OnClickListener, OnFragmentButtonClick{

    private static int currentpage = 0;
    ImageButton datePicker;
    EditText txtDate;
    EditText descrip;
    ToggleButton btn;
    TextView text;
    ImageView img;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.transaction_reports);

        datePicker = (ImageButton)findViewById(calendaricon);
        txtDate = (EditText)findViewById(R.id.in_date);
        descrip = (EditText)findViewById(R.id.in_description);
        btn = (ToggleButton)findViewById(R.id.toggleButton);
        text = (TextView)findViewById(R.id.textView);
        img = (ImageView)findViewById(R.id.boxicon);
        button = (Button)findViewById(R.id.button);

        datePicker.setOnClickListener(this);
        txtDate.setOnClickListener(this);
        button.setOnClickListener(this);

        // Layout manager that allows the user to flip through the pages
        final ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // getSupportFragmentManager allows use to interact with the fragments
        // MyFragmentPagerAdapter will return a fragment based on an index that is passed
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        final IndicatorView indicator = (IndicatorView) findViewById(R.id.circle_indicator_view);
        indicator.setPageIndicators(2);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener(){

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if(state == ViewPager.SCROLL_STATE_IDLE)
                {
                   int pagecount = 2;
                    if(currentpage == 0)
                    {
                        viewPager.setCurrentItem(pagecount-1, false);
                        indicator.setActiveIndicatorColor(R.color.colorPrimary);
                        indicator.setInactiveIndicatorColor(R.color.colorAccent);
                    }
                    else if(currentpage == pagecount -1)
                    {
                       viewPager.setCurrentItem(0, false);
                        indicator.setActiveIndicatorColor(R.color.colorPrimary);
                        indicator.setInactiveIndicatorColor(R.color.colorAccent);
                    }
                }

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {

        if(v == datePicker || v == txtDate)
        {
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    txtDate.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);

                }
            }, year, month, day);
            datePickerDialog.show();
        }

        if(v == button)
        {

        }
    }

    @Override
    public void onFragmentChoose(String category) {
        if(category == "food")
        {
            text.setText("Food");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.food_logo);
        }
        else if(category == "shopping")
        {
            text.setText("Shopping");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.shopping_logo);
        }
        else if(category == "healthcare")
        {
            text.setText("Healthcare");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.healthcare_logo);
        }
        else if(category == "home")
        {
            text.setText("Home");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.home_logo);
        }
        else if(category == "travel")
        {
            text.setText("Travel");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.travel_logo);
        }
        else if(category == "family")
        {
            text.setText("Family");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.family_logo);
        }
        else if(category == "groceries")
        {
            text.setText("Groceries");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.groceries_logo);
        }
        else if(category == "bills")
        {
            text.setText("Bills");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.bills_logo);
        }
        else if(category == "education")
        {
            text.setText("Education");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.education_logo);
        }
        else if(category == "car")
        {
            text.setText("Car");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.car_logo);
        }
        else if(category == "entertainment")
        {
            text.setText("Entertainment");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.entertainment_logo);
        }
        else if(category == "addnew")
        {
            text.setText("New Category");
            text.setTextColor(Integer.parseInt("#951b81"));
            img.setImageResource(R.drawable.addnew_logo);
        }
    }
}
