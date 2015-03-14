package com.ign.tapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ign.tapp1.R;

public class Tapp extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tapp);
		
		}
		
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu for use in the action bar
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.tapp_activity_actions, menu);
		return super.onCreateOptionsMenu(menu); 
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar item

		switch (item.getItemId()) {
		case R.id.action_settings:
			openSettings();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void openSettings() {
		// TODO Auto-generated method stub

		Intent openSettings = new Intent("com.ign.tapp.SETTINGS");
		startActivity(openSettings);
	}

}
		
