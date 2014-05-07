

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
import com.nhtechip.andriod.myapp.fragment.ListCardFragment;
import com.nhtechip.andriod.myapp.fragment.ListColorFragment;
import com.nhtechip.andriod.myapp.fragment.ChangeValueCardFragment;
import com.nhtechip.andriod.myapp.fragment.GridGplayCABFragment;
import com.nhtechip.andriod.myapp.fragment.StaggeredGridFragment;
import com.nhtechip.andriod.myapp.fragment.BaseStaggeredGridFragment;
import com.nhtechip.andriod.myapp.fragment.CroutonFragment;
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
        return 8;
    }

    @Override
    public Fragment getItem(final int position) {
        final Fragment result;
        switch (position) {
            case 0:
                result = new ListCardFragment();
                break;
            case 1:
                result = new ListNewFragment();
                break;
            case 2:
                result = new ListColorFragment();
                break;
            case 3:
                result = new ChangeValueCardFragment();
                break;
            case 4:
                result = new GridGplayCABFragment();
                break;
            case 5:
                result = new BaseStaggeredGridFragment();
                break;
            case 6:
                result = new CroutonFragment();
                break;
            case 7:
                result = new CroutonFragment();
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
            case 3:
                return  "Thay doi";
            case 4:
                return  "Grid";
            case 5:
                return  "Picaso";
            case 6:
                return  "Crouton";
            case 7:
                return  "Picaso2";
            default:
                return null;
        }
    }
}
