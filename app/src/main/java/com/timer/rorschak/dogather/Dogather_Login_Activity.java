package com.timer.rorschak.dogather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;


/**
 * DoGatherLoginActivity.java - LoginActivity of dogather app
 * @author  Rorschak1
 * @version 1.0
 */

public class Dogather_Login_Activity extends AppCompatActivity{

    private Button signIn,signUp;
    private EditText usrName,usrPwd;
    List<NameValuePair> params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("loggin test", "onCreate: ");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        usrName=(EditText) findViewById(R.id.usr_name);
        usrName=(EditText) findViewById(R.id.usr_pwd);
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
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateCallhomescreen();
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    private void validateCallhomescreen() {

        requestWithSomeHttpHeaders();
        Intent intent=new Intent(Dogather_Login_Activity.this,DoGatherHomeActivity.class);
        startActivity(intent);


    }


    public void requestWithSomeHttpHeaders() {

        String usr = usrName.getText().toString();
        String pwd = usrPwd.getText().toString();
        params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("email", usr));
        params.add(new BasicNameValuePair("password", usr));

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://10.0.2.2:8080/register";
        StringRequest postRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR","error => "+error.toString());
                    }
                }
        );
        queue.add(postRequest);

    }
}
