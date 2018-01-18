package com.example.meravdor.supermarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

public class SalesActivity extends AppCompatActivity {


    private Firebase mRef;

    private ArrayList<String> mSalesnames = new ArrayList<>();

    private ListView mListView;


    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_sales);

        Firebase.setAndroidContext(getApplicationContext());

        mRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Sales");

        mListView = (ListView)findViewById(R.id.listViewSales);

        final ArrayAdapter<String> arrayadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mSalesnames);

        mListView.setAdapter(arrayadapter);

        mRef.addChildEventListener(new ChildEventListener() {


            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String value = dataSnapshot.child("nameofproduct").getValue(String.class);

                mSalesnames.add("Product: "+value);

                String value2 = dataSnapshot.child("price").getValue(String.class);
                mSalesnames.add("New Price: " + value2);
                arrayadapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });


            }

}

