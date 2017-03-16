package billdozer.com.testxml;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import billdozer.com.testxml.stab.SlidingTabLayout;

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

public class MainActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*// Allows you to interact with Fragments in an Activity
        FragmentManager fragmentManager = getFragmentManager();

        // beginTransaction() begins the FragmentTransaction which allows you to
        // add, attach, detach, hide, remove, replace, animate, transition or
        // show fragments
        final FragmentTransaction fragmentTransaction =
        fragmentManager.beginTransaction();

        // The Configuration object provides device configuration info
        // http://developer.android.com/reference/android/content/res/Configuration.html
        final Configuration configInfo = getResources().getConfiguration();

        // Depending on the screen orientation replace with the correct fragment
        if(configInfo.orientation == Configuration.ORIENTATION_LANDSCAPE){
            FragmentLandscape fragmentLandscape = new FragmentLandscape();
            fragmentTransaction.replace(android.R.id.content, fragmentLandscape);
        } else {

            FragmentPortrait fragmentPortrait = new FragmentPortrait();
            fragmentTransaction.replace(android.R.id.content, fragmentPortrait);
        }

        // Schedule for the replacement of the Fragment as soon as possible
        fragmentTransaction.commit();*/

        setContentView(R.layout.activity_main);

        // Layout manager that allows the user to flip through the pages
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        SlidingTabLayout tabLayout = (SlidingTabLayout)findViewById(R.id.tabDots);
        tabLayout.setViewPager(viewPager, true);

        // getSupportFragmentManager allows use to interact with the fragments
        // MyFragmentPagerAdapter will return a fragment based on an index that is passed
        viewPager.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));

        // Initialize the Sliding Tab Layout
       // SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.sliding_tabs);

        // Connect the viewPager with the sliding tab layout
       // slidingTabLayout.setViewPager(viewPager);
    }
}
