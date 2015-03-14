package com.ign.tapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ign.tapp1.R;

public class SettingsArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;

	public SettingsArrayAdapter(Context context, String[] values) {
		super(context, R.layout.activity_settings, values);
		this.context = context;
		this.values = values;
		
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View rowView = inflater.inflate(R.layout.activity_settings, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
		textView.setText(values[position]);

		// Change icon based on name
		String s = values[position];

		System.out.println(s);

		if (s.equals("Account")) {
			imageView.setImageResource(R.drawable.account_img);
		} else if (s.equals("Bank accounts")) {
			imageView.setImageResource(R.drawable.bankaccs_img);
		} else if (s.equals("Transaction history")) {
			imageView.setImageResource(R.drawable.transaction_img);
		} else {
			imageView.setImageResource(R.drawable.notifications_img);
		}

		return rowView;
	}
}
