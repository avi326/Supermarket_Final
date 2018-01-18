package com.example.meravdor.supermarket;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AdminMenuActivity extends AppCompatActivity implements  View.OnClickListener {
    private Button buttonLogout;
    private FirebaseAuth firebaseAuth;
    private FirebaseAnalytics mFirebaseAnalytics;
    private static final String TAG = "";
    private TextView textViewEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);

//        if(!FirebaseApp.getApps(this).isEmpty()) {///////////////////////////////////////////////
//            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        }
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonLogout.setOnClickListener(this);

        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();
        textViewEmail = (TextView) findViewById(R.id.TextViewEmail);
        ////////////////////////////////////////////////////////////////////////////////////////
        String emailAdmin = "maayan@gmail.com";
        if (emailAdmin.equals(user.getEmail())) {
            textViewEmail.setText("hello admin " + user.getEmail());
        } else {
            textViewEmail.setText("hello " + user.getEmail());
        }

        final Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                // Code here executes on main thread after user presses button

                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());
                String btrName = "Map Button";
                Intent i = new Intent(AdminMenuActivity.this, MapsActivity.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics.logEvent(btrName, params);
//                ButtonClick(v, MapsActivity.class);
            }
        });


        final Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());
                String btrName = "Profile Button";
                Intent i = new Intent(AdminMenuActivity.this, ProfileActivity.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics.logEvent(btrName, params);
//                ButtonClick(v,ProfileActivity.class);
            }
        });

        final Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());
                String btrName = "README Button";
                Intent i = new Intent(AdminMenuActivity.this, README.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics.logEvent(btrName, params);
                // Code here executes on main thread after user presses button
//                ButtonClick(v, README.class);
            }
        });




        final Button mbutton7 = findViewById(R.id.button7);
        mbutton7.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());
                String btrName = "Products Button";
                Intent i = new Intent(AdminMenuActivity.this, MenuProductActivity.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics.logEvent(btrName, params);
//                ButtonClick(v,MenuProductActivity.class);
            }
        });

        final Button ButtonUserList = findViewById(R.id.ButtonUserList);
        ButtonUserList.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("InvalidAnalyticsName")
            public void onClick(View v) {
                Bundle params = new Bundle();
                params.putInt("Button :", v.getId());
                String btrName = "Products Button";
                Intent i = new Intent(AdminMenuActivity.this, UserListActivity.class);
                startActivity(i);
                Log.d(TAG, "Button click logged" + btrName);
                mFirebaseAnalytics.logEvent(btrName, params);
//                ButtonClick(v,MenuProductActivity.class);
            }
        });

    }

    public void onClick(View view) {
        if (view == buttonLogout) {
            firebaseAuth.signOut();
            finish();
        }
    }
}


