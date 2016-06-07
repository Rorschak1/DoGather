package com.timer.rorschak.dogather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * DoGatherLoginActivity.java - LoginActivity of dogather app
 * @author  Rorschak1
 * @version 1.0
 */

public class Dogather_Login_Activity extends AppCompatActivity {

    private Button signIn;
    private Button signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        signIn=(Button)findViewById(R.id.sign_in);
        signUp=(Button)findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(Dogather_Login_Activity.this, SignUpActivity.class));
                Dogather_Login_Activity.this.overridePendingTransition(R.anim.slide_up, R.anim.stay);
            }
        });


    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }
}
