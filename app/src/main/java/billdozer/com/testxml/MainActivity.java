package billdozer.com.testxml;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import io.github.kshitij_jain.indicatorview.IndicatorView;

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

    private static int currentpage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                        indicator.setActiveIndicatorColor(R.color.active_indicator);
                        indicator.setInactiveIndicatorColor(R.color.inactive_indicator);
                    }
                    else if(currentpage == pagecount -1)
                    {
                       viewPager.setCurrentItem(0, false);
                        indicator.setActiveIndicatorColor(R.color.active_indicator);
                        indicator.setInactiveIndicatorColor(R.color.inactive_indicator);
                    }
                }

            }
        });
    }
}
