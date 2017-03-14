package billdozer.com.testxml;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Steve on 3/14/2017.
 */

public class ImageViewPagerAdapter extends FragmentPagerAdapter {
    private Context _context;
    public static int totalPage = 2;

    public ImageViewPagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        _context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment f = new Fragment();
        switch (position){
            case 0:
                f = new Fragment();
                break;
            case 1:
                f = new Fragment();
                break;
        }
        return f;
    }

    @Override
    public int getCount() {
        return totalPage;
    }
}
