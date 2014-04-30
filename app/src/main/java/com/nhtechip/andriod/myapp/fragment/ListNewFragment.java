package com.nhtechip.andriod.myapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhtechip.andriod.myapp.R;
import com.nhtechip.andriod.myapp.ui.BootstrapPagerAdapter;
import com.viewpagerindicator.TitlePageIndicator;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Fragment which houses the View pager.
 */
public class ListNewFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_new, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Views.inject(this, getView());

    }
}