package com.androidbegin.parseloadmore;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<Numbers> numberlist = null;
	private ArrayList<Numbers> arraylist;
	protected int count;

	public ListViewAdapter(Context context, List<Numbers> numberlist) {
		mContext = context;
		this.numberlist = numberlist;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<Numbers>();
		this.arraylist.addAll(numberlist);
	}

	public class ViewHolder {
		TextView num;

	}

	@Override
	public int getCount() {
		return numberlist.size();
	}

	@Override
	public Numbers getItem(int position) {
		return numberlist.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	public View getView(final int position, View view, ViewGroup parent) {
		final ViewHolder holder;
		if (view == null) {
			holder = new ViewHolder();
			view = inflater.inflate(R.layout.listview_item, null);
			// Locate the TextView in listview_item.xml
			holder.num = (TextView) view.findViewById(R.id.num);

			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}
		// Set the results into TextView
		holder.num.setText(numberlist.get(position).getNum());
		// Listen for ListView Item Click
		view.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Send single item click data to SingleItemView Class
				Intent intent = new Intent(mContext, SingleItemView.class);
				// Pass all data number
				intent.putExtra("num", (numberlist.get(position).getNum()));
				// Start SingleItemView Class
				mContext.startActivity(intent);
			}
		});

		return view;
	}
}