package com.ign.tapp;

import com.ign.tapp.adapter.SettingsArrayAdapter;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
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
		String notify = (String) getListAdapter().getItem(position) + " selected";
		
		if (selectedValue == "Transaction history"){
			selectedValue = "TransactionHistory";
		}
		
		if (selectedValue == "Bank accounts"){
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
}
