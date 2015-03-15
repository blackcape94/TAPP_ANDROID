package com.rapda.tappalpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Splash extends Activity {

	@Override
	protected void onCreate(Bundle start) {
		// TODO Auto-generated method stub
		super.onCreate(start);
		setContentView(R.layout.activity_splash);
		
		Thread timer = new Thread() {
			public void run() {

				try {
					sleep(4000);

				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				finally {
                     Intent openJoin = new Intent(getApplicationContext(), Tapp.class);
                     startActivity(openJoin);
				}
			}
		};

		timer.start();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

}
