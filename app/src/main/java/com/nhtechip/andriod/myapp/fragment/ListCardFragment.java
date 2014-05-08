package com.nhtechip.andriod.myapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import com.nhtechip.andriod.myapp.R;

import butterknife.InjectView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.base.BaseCard;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import butterknife.Views;

import android.support.v4.view.ViewPager;
import com.viewpagerindicator.CirclePageIndicator;
import com.nhtechip.andriod.myapp.adapter.PlaceSlidesFragmentAdapter;
import com.viewpagerindicator.PageIndicator;
import com.viewpagerindicator.TitlePageIndicator;
import com.nhtechip.andriod.myapp.fragment.MainFragment;

import com.nhtechip.andriod.myapp.adapter.TestFragmentAdapter;
/**
 * Created by tung1123 on 5/1/2014.
 */
public class ListCardFragment  extends Fragment {

    PlaceSlidesFragmentAdapter mAdapter;
   // TestFragmentAdapter mAdapter;

    @InjectView(R.id.indicatorImage)
    protected CirclePageIndicator indicator;

    @InjectView(R.id.pagerimage)
    protected ViewPager pager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_card, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Views.inject(this, getView());
        mAdapter = new PlaceSlidesFragmentAdapter(getActivity().getSupportFragmentManager());
       // mAdapter = new TestFragmentAdapter(getActivity().getSupportFragmentManager());

        //mPager = (ViewPager)  getView().findViewById(R.id.pagerimage);
        pager.setAdapter(mAdapter);
        indicator.setViewPager(pager);
        pager.setCurrentItem(1);
     /*

        //indicator = (CirclePageIndicator) getView().findViewById(R.id.indicatorImage);
        indicator.setViewPager(pager);
        //((CirclePageIndicator) indicator).setSnap(true);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ListCardFragment.this.getActivity(),
                        "Changed to page " + position,
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrolled(int position,
                                       float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
   */
  /*      ArrayList<Card> cards = new ArrayList<Card>();
        //Create a Card
        Card card = new Card(getActivity().getBaseContext());
        //Create a CardHeader
        CardHeader header = new CardHeader(getActivity().getBaseContext());
        header.setButtonOverflowVisible(true);
        header.setTitle("Google Maps");
        header.setPopupMenu(R.menu.popupmain, new CardHeader.OnClickCardHeaderPopupMenuListener() {
            @Override
            public void onMenuItemClick(BaseCard card, MenuItem item) {
                Toast.makeText(getActivity().getBaseContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        //Add Header to card
        card.addCardHeader(header);
        cards.add(card);

        CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(),cards);
        CardListView listView = (CardListView) getActivity().findViewById(R.id.myList);
        if (listView!=null){
            listView.setAdapter(mCardArrayAdapter);
        }*/
    }

}