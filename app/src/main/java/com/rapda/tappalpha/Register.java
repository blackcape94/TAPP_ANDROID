package com.rapda.tappalpha;


import org.json.JSONException;
import org.json.JSONObject;

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
	EditText inputFullName;
	TextView registerErrorMsg;
	
	 // JSON Response node names
    private static String KEY_SUCCESS = "success";
    private static String KEY_ERROR = "error";
    private static String KEY_ERROR_MSG = "error_msg";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		
		btnRegister= (Button) findViewById(R.id.JoinButton);
		LoginLink= (Button) findViewById(R.id.handLogin);
		inputEmail = (EditText) findViewById(R.id.emailReg);
	    inputPassword = (EditText) findViewById(R.id.passReg);
	    inputFullName = (EditText) findViewById(R.id.fullnameReg);
	    registerErrorMsg = (TextView) findViewById(R.id.register_error);
	    
	 // Register Button Click event
        btnRegister.setOnClickListener(new View.OnClickListener() {         
            public void onClick(View view) {
                String name = inputFullName.getText().toString();
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