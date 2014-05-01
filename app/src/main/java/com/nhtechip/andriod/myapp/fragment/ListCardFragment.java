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
import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.internal.CardThumbnail;
import it.gmariotti.cardslib.library.internal.base.BaseCard;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;
import butterknife.Views;

/**
 * Created by tung1123 on 5/1/2014.
 */
public class ListCardFragment  extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_card, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Views.inject(this, getView());
        ArrayList<Card> cards = new ArrayList<Card>();
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
        }
    }

}