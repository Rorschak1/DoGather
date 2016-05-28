package com.timer.rorschak.dogather;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * UserWelcomeActivity.java - Activity fired from splash. Container for welcome fragment
 * @author  Rorschak1
 * @version 1.0
 */

public class UserWelcomeActivity extends AppCompatActivity {

    private Fragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_welcome);

        mFragment = getSupportFragmentManager().findFragmentById(R.id.base_fragment);
        if (!(mFragment instanceof UserWelcomeFragment)) {
            mFragment=UserWelcomeFragment.instantiate(UserWelcomeActivity.this, UserWelcomeFragment.class.getName());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.base_fragment, mFragment, UserWelcomeFragment.class.getSimpleName())
                    .commit();

        }
    }
}
