package com.nhtechip.andriod.myapp.fragment;

/**
 * Created by tung1123 on 5/1/2014.
 */

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.nhtechip.andriod.myapp.R;
import com.nhtechip.andriod.myapp.staggered.DynamicHeightPicassoCardThumbnailView;
import com.nhtechip.andriod.myapp.staggered.data.Image;
import com.nhtechip.andriod.myapp.staggered.data.MockImageLoader;
import com.nhtechip.andriod.myapp.staggered.data.Section;
import com.nhtechip.andriod.myapp.staggered.data.ServerDatabase;
import it.gmariotti.cardslib.library.extra.staggeredgrid.internal.CardGridStaggeredArrayAdapter;
import it.gmariotti.cardslib.library.extra.staggeredgrid.view.CardGridStaggeredView;
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardThumbnail;


import com.etsy.android.grid.StaggeredGridView;
import com.nhtechip.andriod.myapp.adapter.SampleAdapter;
import com.nhtechip.andriod.myapp.model.SampleData;
/**
 * This example uses a staggered card with different different photos and text.
 *
 * This example uses cards with a foreground layout.
 * Pay attention to style="@style/card.main_layout_foreground" in card layout.
 *
 * .DynamicHeightPicassoCardThumbnailView
 *
 * @author Gabriele Mariotti (gabri.mariotti@gmail.com)
 */
public class StaggeredGridFragment extends Fragment {

    private StaggeredGridView mGridView;
    private boolean mHasRequestedMore;
    private SampleAdapter mAdapter;

    private ArrayList<String> mData;

    ServerDatabase mServerDatabase;
    CardGridStaggeredArrayAdapter mCardArrayAdapter;

    public StaggeredGridFragment() {
        super();
    }
/*
    @Override
    public int getTitleResourceId() {
        return R.string.carddemo_extras_title_staggered;
    }
*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_sgv, container, false);//demo_extras_fragment_staggeredgrid
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        new LoaderInitAsyncTask(activity).execute();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mGridView = (StaggeredGridView) getView().findViewById(R.id.grid_view);

        if (savedInstanceState == null) {
            final LayoutInflater layoutInflater = getActivity().getLayoutInflater();

            View header = layoutInflater.inflate(R.layout.list_item_header_footer, null);
            View footer = layoutInflater.inflate(R.layout.list_item_header_footer, null);
            TextView txtHeaderTitle = (TextView) header.findViewById(R.id.txt_title);
            TextView txtFooterTitle = (TextView) footer.findViewById(R.id.txt_title);
            txtHeaderTitle.setText("THE HEADER!");
            txtFooterTitle.setText("THE FOOTER!");

            mGridView.addHeaderView(header);
            mGridView.addFooterView(footer);
        }

        if (mAdapter == null) {
            mAdapter = new SampleAdapter(getActivity(), R.id.txt_line1);
        }

        if (mData == null) {
            mData = SampleData.generateSampleData();
        }

        for (String data : mData) {
            mAdapter.add(data);
        }

        mGridView.setAdapter(mAdapter);
      /*  //Set the arrayAdapter
        ArrayList<Card> cards = new ArrayList<Card>();
        mCardArrayAdapter = new CardGridStaggeredArrayAdapter(getActivity(), cards);

        CardGridStaggeredView staggeredView = (CardGridStaggeredView) getActivity().findViewById(R.id.carddemo_extras_grid_stag);

        //Set the empty view
        staggeredView.setEmptyView(getActivity().findViewById(android.R.id.empty));
        if (staggeredView != null) {
            staggeredView.setAdapter(mCardArrayAdapter);
        }*/

        //Load cards
       // new LoaderAsyncTask().execute();
    }


    /**
     * Async Task to init images
     */
    class LoaderInitAsyncTask extends AsyncTask<Void, Void, Void> {

        Context mContext;


        LoaderInitAsyncTask(Context context) {
            mContext = context;
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Initialize Image loader
            MockImageLoader loader = MockImageLoader.getInstance(((Activity)mContext).getApplication());
            mServerDatabase = new ServerDatabase(loader);
            return null;
        }
    }

    /**
     * Async Task to elaborate images
     */
    class LoaderAsyncTask extends AsyncTask<Void, Void, Void> {

        LoaderAsyncTask() {
        }

        @Override
        protected Void doInBackground(Void... params) {
            //elaborate images
            mServerDatabase.getImagesForSection(Section.STAG);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid){
            //Update the adapter
            updateAdapter();
        }
    }


    /**
     * This method builds a simple list of cards
     */
    private ArrayList<Card> initCard() {

        ArrayList<Card> cards = new ArrayList<Card>();
        for (int i = 0; i < 100; i++) {

            StaggeredCard card = new StaggeredCard(getActivity());
            card.headerTitle = "PHOTO " + i;

            //Only for test, use different images from images loader
            int xx = i % 8;
            switch (xx) {
                case 0:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(0);
                    break;
                case 1:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(1);
                    break;
                case 2:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(2);
                    break;
                case 3:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(3);
                    break;
                case 4:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(4);
                    break;
                case 5:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(5);
                    break;
                case 6:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(6);
                    break;
                case 7:
                    card.image = mServerDatabase.getImagesForSection(Section.STAG).get(7);
                    break;
            }

            card.init();
            cards.add(card);
        }

        return cards;

    }

    /**
     * Update the adapter
     */
    private void updateAdapter() {
        ArrayList<Card> cards = initCard();
        mCardArrayAdapter.addAll(cards);
        mCardArrayAdapter.notifyDataSetChanged();
    }

    /**
     * Card
     */
    public class StaggeredCard extends Card {

        protected int height;
        protected String headerTitle;

        protected Image image;

        public StaggeredCard(Context context) {
            super(context, R.layout.carddemo_extras_staggered_inner_main);
        }

        private void init() {
            /*
//Add the header
CardHeader header = new CardHeader(getContext());
header.setTitle(headerTitle);
header.setPopupMenu(R.menu.extras_popupmain, new CardHeader.OnClickCardHeaderPopupMenuListener() {
@Override
public void onMenuItemClick(BaseCard card, MenuItem item) {
Toast.makeText(getContext(),"Header:"+ ((Card) card).getCardHeader().getTitle() + "Item " + item.getTitle(), Toast.LENGTH_SHORT).show();
}
});
addCardHeader(header);
*/

            //Add the thumbnail
            StaggeredCardThumb thumbnail = new StaggeredCardThumb(getContext());
            thumbnail.image = image;
            addCardThumbnail(thumbnail);

            //A simple clickListener
            setOnClickListener(new OnCardClickListener() {
                @Override
                public void onClick(Card card, View view) {
                    //Do something
                }
            });
        }

        @Override
        public void setupInnerViewElements(ViewGroup parent, View view) {

            TextView title = (TextView) view.findViewById(R.id.carddemo_staggered_inner_title);
            title.setText(image.title.toUpperCase());

            TextView subtitle = (TextView) view.findViewById(R.id.carddemo_staggered_inner_subtitle);
            subtitle.setText(getString(R.string.carddemo_extras_title_stag));
        }


        /**
         * A StaggeredCardThumbnail.
         * It uses a DynamicHeightPicassoCardThumbnailView which maintains its own width to height ratio.
         */
        class StaggeredCardThumb extends CardThumbnail {

            Image image;

            public StaggeredCardThumb(Context context) {
                super(context);
                setExternalUsage(true);
            }

            @Override
            public void setupInnerViewElements(ViewGroup parent, View viewImage) {

                //Use a DynamicHeightPicassoCardThumbnailView to maintain width/height ratio
                DynamicHeightPicassoCardThumbnailView thumbView = (DynamicHeightPicassoCardThumbnailView) getCardThumbnailView();
                thumbView.bindTo(image);

            }
        }

    }


}