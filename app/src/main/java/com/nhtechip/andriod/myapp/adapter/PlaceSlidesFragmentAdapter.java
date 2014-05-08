package com.nhtechip.andriod.myapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.viewpagerindicator.IconPagerAdapter;
import com.nhtechip.andriod.myapp.R;
import  com.nhtechip.andriod.myapp.fragment.PlaceSlideFragment;
/**
 * Created by tung1123 on 5/7/2014.
 */
public class PlaceSlidesFragmentAdapter extends FragmentPagerAdapter implements
        IconPagerAdapter {

    private int[] Images = new int[] { R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d

    };

    protected static final int[] ICONS = new int[] { R.drawable.ic_home,
            R.drawable.ic_home, R.drawable.ic_home, R.drawable.ic_home };

    private int mCount = Images.length;

    public PlaceSlidesFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PlaceSlideFragment(Images[position]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public int getIconResId(int index) {
        return ICONS[index % ICONS.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}