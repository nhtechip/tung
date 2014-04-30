

package com.nhtechip.andriod.myapp.adapter;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.nhtechip.andriod.myapp.R;
import com.nhtechip.andriod.myapp.ui.CheckInsListFragment;
import com.nhtechip.andriod.myapp.ui.NewsListFragment;
import com.nhtechip.andriod.myapp.ui.UserListFragment;

import com.nhtechip.andriod.myapp.fragment.ListNewFragment;
/**
 * Pager adapter
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private final Resources resources;

    /**
     * Create pager adapter
     *
     * @param resources
     * @param fragmentManager
     */
    public MainPagerAdapter(final Resources resources, final FragmentManager fragmentManager) {
        super(fragmentManager);
        this.resources = resources;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(final int position) {
        final Fragment result;
        switch (position) {
            case 0:
                result = new ListNewFragment();
                break;
            case 1:
                result = new ListNewFragment();
                break;
            case 2:
                result = new ListNewFragment();
                break;
            default:
                result = null;
                break;
        }
        if (result != null) {
            result.setArguments(new Bundle()); //TODO do we need this?
        }
        return result;
    }

    @Override
    public CharSequence getPageTitle(final int position) {
        switch (position) {
            case 0:
                return "1";
            case 1:
                return "1";
            case 2:
                return  "1";
            default:
                return null;
        }
    }
}
