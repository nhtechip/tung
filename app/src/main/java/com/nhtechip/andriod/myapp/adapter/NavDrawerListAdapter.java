package com.nhtechip.andriod.myapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nhtechip.andriod.myapp.R;
import com.nhtechip.andriod.myapp.model.NavDrawerItem;

import java.util.ArrayList;

public class NavDrawerListAdapter extends BaseAdapter

{
	private Context context;
	private ArrayList<NavDrawerItem> navDrawerItems;
	
	
	

	public NavDrawerListAdapter(Context context,
                                ArrayList<NavDrawerItem> navDrawerItems) {
		super();
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return navDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return  navDrawerItems.size();
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent)
	{
		if(view==null)
		{
			LayoutInflater inflater=(LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			view=inflater.inflate(R.layout.drawer_list_item, null);
		}
		ImageView icon=(ImageView) view.findViewById(R.id.icon);
		TextView title=(TextView) view.findViewById(R.id.title);
		TextView count=(TextView) view.findViewById(R.id.counter);
		icon.setImageResource(navDrawerItems.get(position).getIcon());
		title.setText(navDrawerItems.get(position).getTitle());
		
		
		if(navDrawerItems.get(position).getCounterVisibility()){
        	count.setText(navDrawerItems.get(position).getCount());
        }else{
        	// hide the counter view
        	count.setVisibility(View.GONE);
        }
	
		
		return view;
	}

}
