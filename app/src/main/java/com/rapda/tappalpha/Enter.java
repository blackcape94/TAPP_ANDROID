package com.rapda.tappalpha;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by eesha_000 on 19/06/2015.
 */
public class Enter extends Activity{

    TextView Header;

    @Override
    protected void onCreate(Bundle start) {
        // TODO Auto-generated method stub
        super.onCreate(start);
        setContentView(R.layout.activity_enter);
        Typeface billabong = Typeface.createFromAsset(getAssets(),"billabong_regular.ttf");
        Header =(TextView) findViewById(R.id.enter_header);
        Header.setTypeface(billabong);

        Button emailSignup = (Button) findViewById(R.id.emailSignup);;
        emailSignup.setPaintFlags(emailSignup.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

}



