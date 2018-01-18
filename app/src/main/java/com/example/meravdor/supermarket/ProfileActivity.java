package com.example.meravdor.supermarket;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

public class ProfileActivity extends AppCompatActivity {
    static TextView txtfirstname;
    static TextView txtlastname;
    static TextView txtstreet;
    static TextView txtcity;
    static TextView txtemail;
    static TextView txtpassword;
    static TextView txtuser;
    static ImageView imageview;
    private Firebase FirstNameRef;
    private Firebase LastNamwRef;
    private Firebase StreetRef;
    private Firebase CityRef;
    private Firebase PasswordRef;
    private Firebase EmailRef;
    private Firebase PathRef;
    private Firebase UserRef;
    String x;
    private FirebaseDatabase mFirebaseDatabase;
    DatabaseReference databaseReference;
    DatabaseReference databaseReference1;
    private StorageReference storageReference;
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    private String uri;
    private static final int CAMERA_REQUEST_CODE=1;

    //    private static final String STORAGE_PATH="image/";
//    private static final String DATABASE_PATH="mainObject";
    String userId;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Firebase.setAndroidContext(this);
        txtfirstname = (TextView)findViewById(R.id.FirstName);
        imageview=(ImageView)findViewById((R.id.imagView)) ;

        mAuth = FirebaseAuth.getInstance();
//        databaseReference = mFirebaseDatabase.getReference();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        storageReference= FirebaseStorage.getInstance().getReference();

        firebaseUser = mAuth.getCurrentUser();
        userId = firebaseUser.getUid();
        FirstNameRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userFirstName");
        FirstNameRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtfirstname.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        txtlastname = (TextView)findViewById(R.id.LastName);
        LastNamwRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userLastName");
        LastNamwRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtlastname.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        txtuser = (TextView)findViewById(R.id.User);
        UserRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userFirstName");
        UserRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtuser.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        txtstreet = (TextView)findViewById(R.id.Street);
        StreetRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userStreet");
        StreetRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtstreet.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        txtcity = (TextView)findViewById(R.id.City);
        CityRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userCity");
        CityRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtcity.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });



        txtpassword = (TextView)findViewById(R.id.Password);
        PasswordRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userPassword");
        PasswordRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtpassword.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        txtemail = (TextView)findViewById(R.id.Email);
        EmailRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/userEmail");
        EmailRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                ProfileActivity.txtemail.setText(value);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        PathRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Users/"+userId+"/url");
        PathRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value=dataSnapshot.getValue(String.class);
                x=value;
                Picasso.with(getApplicationContext()).load(x).into(imageview);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

}