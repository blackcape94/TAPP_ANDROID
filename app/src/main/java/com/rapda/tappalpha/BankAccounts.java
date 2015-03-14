package com.ign.tapp;

import library.DatabaseHandler;
import library.JSONParser;
import library.UserFunctions;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.ign.tapp1.R;

public class BankAccounts extends Activity{
	
	// JSON Response node names
    private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";
    private static String KEY_ERROR_MSG = "error_msg";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";
	
public boolean onCreateOptionsMenu (Menu menu) {
		
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.bankaccount_activity_actions, menu);
		return super.onCreateOptionsMenu(menu);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle presses on the action bar item
		switch (item.getItemId()) {
		case R.id.action_add:
			openAddBankAccount();
			return true;
		
		case R.id.action_edit:
			return true;
			
		case R.id.action_delete:
			return true;
			
		default:
			return super.onOptionsItemSelected(item);
		}
	}
	
	private void openAddBankAccount() {
		// TODO Auto-generated method stub

		Intent openSettings = new Intent("com.ign.tapp.AddBankAccount");
		startActivity(openSettings);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bank_accounts);
	}
	
	

}
