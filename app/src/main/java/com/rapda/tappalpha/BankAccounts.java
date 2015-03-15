package com.rapda.tappalpha;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by eesha_000 on 15/03/2015.
 */


public class BankAccounts extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_accounts);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bankaccount_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar item

        switch (item.getItemId()) {
            case R.id.action_add:
                //openSettings();
                return true;

            case R.id.action_edit:
                //openSettings();
                return true;

            case R.id.action_delete:
                //openSettings();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
    private void openSettings() {
        // TODO Auto-generated method stub

        Intent openSettings = new Intent("com.ign.tapp.SETTINGS");
        startActivity(openSettings);
    }
    */

}

