package com.timer.rorschak.dogather;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



/**
 * Splash Activity.java - Splash screen for Dogather app
 * @author  Rorschak1
 * @version 1.0
 */

public class SplashActivity extends AppCompatActivity {


    String test= "somestring";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        isOnline();

        if(isOnline()) {

            if(true/**check if user has to see welcome pages*/)
            {

                Intent intent= new Intent();

            }
            else {

                //take user to login page
            }

        }
        else {

            Intent intent= new Intent(this,ErrorActivity.class);
            startActivity(intent);
        }


    }

    public boolean isOnline() {
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }



}
