package com.rapda.tappalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends Activity {

    EditText inputEmail;
    EditText inputPassword;
    Button Signin;
    Button RegisterBtn;
    TextView loginErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = (EditText) findViewById(R.id.emailLog);
        inputPassword = (EditText) findViewById(R.id.passLog);
        Signin = (Button) findViewById(R.id.signinButton);
        RegisterBtn = (Button) findViewById(R.id.handRegister);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);

     // Login button Click Event
        Signin.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();

            }
        });
        
        // Link to Register Screen
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Join.class);
                startActivity(i);
                finish();
            }
        });
        
    }
}