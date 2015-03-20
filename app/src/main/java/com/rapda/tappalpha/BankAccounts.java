package com.rapda.tappalpha;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by eesha_000 on 15/03/2015.
 */


public class BankAccounts extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_bank_accounts, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    /**
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);

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

