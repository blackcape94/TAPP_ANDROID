package com.rapda.tappalpha;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends ListActivity {

	static final String[] Options = new String[] { "Account", "Bank accounts",
			"Transaction history", "Notifications"};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//setListAdapter(new SettingsArrayAdapter(this, R.layout.activity_settings, R.id.label, Options));
		setListAdapter(new SettingsArrayAdapter(this, Options));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {

		
		//get selected items
		String selectedValue = (String) getListAdapter().getItem(position);
		String notify = getListAdapter().getItem(position) + " selected";
		
		if (selectedValue.equals("Transaction history")){
			selectedValue = "TransactionHistory";
		}
		
		if (selectedValue.equals("Bank accounts")){
			selectedValue = "BankAccounts";
		}
		
		try {
			Class ourClass = Class.forName("com.ign.tapp." + selectedValue);
			
			Toast.makeText(this, notify, Toast.LENGTH_LONG).show();
			Intent ourIntent = new Intent(Settings.this, ourClass);
			startActivity(ourIntent);
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
	}

    public static class SettingsArrayAdapter extends ArrayAdapter<String> {
        private final Context context;
        private final String[] values;

        public SettingsArrayAdapter(Context context, String[] values) {
            super(context, R.layout.activity_settings, values);
            this.context = context;
            this.values = values;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

            View rowView = inflater.inflate(R.layout.activity_settings, parent, false);
            TextView textView = (TextView) rowView.findViewById(R.id.label);
            ImageView imageView = (ImageView) rowView.findViewById(R.id.logo);
            textView.setText(values[position]);

            // Change icon based on name
            String s = values[position];

            System.out.println(s);

            if (s.equals("Account")) {
                imageView.setImageResource(R.mipmap.account_img);
            } else if (s.equals("Bank accounts")) {
                imageView.setImageResource(R.mipmap.bankaccs_img);
            } else if (s.equals("Transaction history")) {
                imageView.setImageResource(R.mipmap.transaction_img);
            } else {
                imageView.setImageResource(R.mipmap.notifications_img);
            }

            return rowView;
        }
    }
}
