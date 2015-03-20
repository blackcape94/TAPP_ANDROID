package com.rapda.tappalpha;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Register extends Activity{

	Button btnRegister;
	Button LoginLink;
	EditText inputEmail;
	EditText inputPassword;
	EditText inputFirstName;
    EditText inputLastName;
	TextView registerErrorMsg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		btnRegister= (Button) findViewById(R.id.SignupButton);
		LoginLink= (Button) findViewById(R.id.handLogin);
		inputEmail = (EditText) findViewById(R.id.emailReg);
	    inputPassword = (EditText) findViewById(R.id.passReg);
	    inputFirstName = (EditText) findViewById(R.id.firstnameReg);
        inputFirstName = (EditText) findViewById(R.id.lastnameReg);
	    registerErrorMsg = (TextView) findViewById(R.id.register_error);
	    
	 // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {         
            public void onClick(View view) {
                String Fname = inputFirstName.getText().toString();
                String Lname = inputLastName.getText().toString();
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
            }
        });
	    
		LoginLink.setOnClickListener(new View.OnClickListener() {
			 
			public void onClick(View view) {
	                Intent i = new Intent(getApplicationContext(),Login.class);
	                startActivity(i);
	                finish();
	            }
		});
	}
}