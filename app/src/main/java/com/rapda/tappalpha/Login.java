package com.ign.tapp;

import library.DatabaseHandler;
import library.UserFunctions;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.ign.tapp1.R;

public class Login extends Activity {

    EditText inputEmail;
    EditText inputPassword;
    Button Signin;
    Button RegisterBtn;
    TextView loginErrorMsg;
    
    // JSON Response node names
    private static String KEY_SUCCESS = "success";
    private static String KEY_UID = "uid";
    private static String KEY_NAME = "name";
    private static String KEY_EMAIL = "email";
    private static String KEY_CREATED_AT = "created_at";

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
                UserFunctions userFunction = new UserFunctions();
                JSONObject json = userFunction.loginUser(email, password);
 
                // check for login response
                try {
                    if (json.getString(KEY_SUCCESS) != null) {
                        loginErrorMsg.setText("");
                        String res = json.getString(KEY_SUCCESS); 
                        if(Integer.parseInt(res) == 1){
                            // user successfully logged in
                            // Store user details in SQLite Database
                            DatabaseHandler db = new DatabaseHandler(getApplicationContext());
                            JSONObject json_user = json.getJSONObject("user");
                             
                            // Clear all previous data in database
                            userFunction.logoutUser(getApplicationContext());
                            db.addUser(json_user.getString(KEY_NAME), json_user.getString(KEY_EMAIL), json.getString(KEY_UID), json_user.getString(KEY_CREATED_AT));                        
                             
                            // Launch TAPP Screen
                            Intent OpenTapp = new Intent(getApplicationContext(), Tapp.class);
                             
                            // Close all views before launching Dashboard
                            OpenTapp.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(OpenTapp);
                             
                            // Close Login Screen
                            finish();
                        }else{
                            // Error in login
                            loginErrorMsg.setText("Incorrect username/password");
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
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