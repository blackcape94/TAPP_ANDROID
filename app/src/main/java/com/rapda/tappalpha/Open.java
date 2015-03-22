package com.rapda.tappalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Open extends Activity {

    Button Login;
    Button Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);

        Login = (Button) findViewById(R.id.LoginButton);
        Register = (Button) findViewById(R.id.RegisterButton);

        // Link to Register Screen
        Login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                startActivity(i);
                finish();
            }
        });

        // Link to Register Screen
        Register.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);
                finish();
            }
        });

    }


}
