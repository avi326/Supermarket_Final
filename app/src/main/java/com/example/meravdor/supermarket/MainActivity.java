package com.example.meravdor.supermarket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "";
    private FirebaseAnalytics mFirebaseAnalytics1;

    private Button mloginButton;
    private Button mregisterButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics1 = FirebaseAnalytics.getInstance(this);
        final Button mregisterButton = findViewById(R.id.registerButton);
        mregisterButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());

                String btrName = "Register Button";
                Intent i = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics1.logEvent(btrName, params);

            }
        });

        final Button mloginButton = findViewById(R.id.loginButton);
        mloginButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());

                String btrName = "Login Button ";
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics1.logEvent(btrName, params);
            }
        });

    }
}