package com.timer.rorschak.dogather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Splash Activity.java - Splash screen for Dogather app
 * @author  Rorschak1
 * @version 1.0
 */

public class SplashActivity extends AppCompatActivity {

    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mButton=(Button) findViewById(R.id.buttonclick);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SplashActivity.this,UserWelcomeActivity.class);
                startActivity(intent);
            }
        });



    }
}
