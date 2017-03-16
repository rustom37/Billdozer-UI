package billdozer.com.testxml;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    // Holds tab titles
    private String tabTitles[] = new String[] { "Frag #1", "Frag #2"};
    private Context context;

    public MyFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    // Return the correct Fragment based on index
    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return new TabFragment1();
        } else if(position == 1) {
            return new TabFragment2();
        }

        return null;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Return the tab title to SlidingTabLayout
        return tabTitles[position];
    }
}