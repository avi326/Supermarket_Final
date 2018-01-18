package com.example.meravdor.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

public class listOfProActivity extends AppCompatActivity {
    static String pro1;
    final static ArrayList<String> productList2 = new ArrayList<String>();
    static TextView txtname1;
    static TextView txtname2;
    static CheckBox box;
    static CheckBox box2;
    private Firebase NameRef1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_pro);
        Firebase.setAndroidContext(this);



        box = (CheckBox) findViewById(R.id.check1);
        box2 = (CheckBox) findViewById(R.id.check2);

        txtname1 = (TextView) findViewById(R.id.nameproduct1);

        NameRef1 = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/advil/name");

        NameRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                listOfProActivity.txtname1.setText(value);
                productList2.add("advil");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });




        final Button info_button1 = findViewById(R.id.infobutton1);
        info_button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                pro1 = "advil";
                Intent i = new Intent(listOfProActivity.this, ProductActivity.class);
                startActivity(i);
            }
        });

        txtname2 = (TextView) findViewById(R.id.nameproduct2);
        NameRef1 = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/oreo/name");

        NameRef1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                listOfProActivity.txtname2.setText(value);
                productList2.add("oreo");
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        final Button info_button2 = findViewById(R.id.infobutton2);
        info_button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                pro1 = "oreo";
                Intent i = new Intent(listOfProActivity.this, ProductActivity.class);
                startActivity(i);
            }
        });


        final Button mylist = findViewById(R.id.mylist);
        mylist.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(listOfProActivity.this, MyListActivity.class);
                startActivity(i);
            }
        });

    }


}
