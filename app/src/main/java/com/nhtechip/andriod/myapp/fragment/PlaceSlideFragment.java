package com.nhtechip.andriod.myapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nhtechip.andriod.myapp.R;

import butterknife.InjectView;
import butterknife.Views;

/**
 * Created by tung1123 on 5/7/2014.
 */
public class PlaceSlideFragment extends Fragment {

    int imageResourceId;
    @InjectView(R.id.introsrc)
    protected ImageView imgView;
    public PlaceSlideFragment(int i) {
        imageResourceId = i;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
          /* ImageView image = new ImageView(getActivity().getApplicationContext());
        image.setImageResource(imageResourceId);
        image.setScaleType(ImageView.ScaleType.FIT_XY);

        TextView text = new TextView(getActivity());
        text.setGravity(Gravity.CENTER);
        text.setText("TTTTTt");
        text.setTextSize(20 * getResources().getDisplayMetrics().density);
        text.setPadding(20, 20, 20, 20);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout layout = new RelativeLayout(getActivity());
        layout.setLayoutParams(new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
        layout.addView(image, params);
        //layout.addView(text);

        LinearLayout layout = new LinearLayout(getActivity().getApplicationContext());
        layout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

        layout.setGravity(Gravity.CENTER);
        layout.addView(image);
        */
        return inflater.inflate(R.layout.list_image_intro, container, false);
        //return layout;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Views.inject(this, getView());

        imgView.setImageResource(imageResourceId);


    }

}