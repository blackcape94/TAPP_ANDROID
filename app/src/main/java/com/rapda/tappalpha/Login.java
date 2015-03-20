package com.rapda.tappalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rapda.tappalpha.rest.service.RestClient;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Login extends Activity {
    private static String TAG = Login.class.getSimpleName();

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
        Signin = (Button) findViewById(R.id.loginButton);
        RegisterBtn = (Button) findViewById(R.id.handRegister);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);

        RestClient.setupRestClient();

     // Login button Click Event
        Signin.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                String email = inputEmail.getText().toString();
                String password = inputPassword.getText().toString();
                RestClient.api().login(new Callback<String>() {
                    @Override
                    public void success(String s, Response response) {
                        Log.e(TAG, s);
                        Log.e(TAG, response.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.e(TAG, error.toString());
                    }
                });
            }
        });
        
        // Link to Register Screen
        RegisterBtn.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Open.class);
                startActivity(i);
                finish();
            }
        });
        
    }
}