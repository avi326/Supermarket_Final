package com.example.meravdor.supermarket;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;


public class ProductActivity extends AppCompatActivity {


    static TextView txtdepartment;
    static TextView txtshelf;
    static TextView txtbarcode;
    static TextView txtprice;
    static TextView txtcapacity;
    static TextView txtname;

    String name;
    String barcode;
    String department;
    String shelf;
    String priceofunit;
    String capacity;

    private Firebase DepartmentRef;
    private Firebase ShelfRef;
    private Firebase BarcodeRef;
    private Firebase PriceRef;
    private Firebase CapacityRef;
    private Firebase NameRef;
    static ArrayList<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Firebase.setAndroidContext(this);
        final ArrayList<Product> products = new ArrayList<Product>();
            txtname = (TextView) findViewById(R.id.Name);

            NameRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/"+listOfProActivity.pro1+"/name");


            NameRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    ProductActivity.txtname.setText(value);
                    name = value;
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            txtbarcode = (TextView) findViewById(R.id.IdProduct);


            BarcodeRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/"+listOfProActivity.pro1+"/barcode");
            BarcodeRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    ProductActivity.txtbarcode.setText(value);
                    barcode = value;
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            txtdepartment = (TextView) findViewById(R.id.Department);


            DepartmentRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/"+listOfProActivity.pro1+"/department");
            DepartmentRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    ProductActivity.txtdepartment.setText(value);
                    department = value;
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            txtshelf = (TextView) findViewById(R.id.Shelf);


            ShelfRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/"+listOfProActivity.pro1+"/shelf");
            ShelfRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    ProductActivity.txtshelf.setText(value);
                    shelf = value;
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            txtcapacity = (TextView) findViewById(R.id.Capacity);


            CapacityRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/"+listOfProActivity.pro1+"/capacity");
            CapacityRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    ProductActivity.txtcapacity.setText(value);
                    capacity = value;
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

            txtprice = (TextView) findViewById(R.id.Price);


            PriceRef = new Firebase("https://supermarket-8ae61.firebaseio.com/Products/"+listOfProActivity.pro1+"/priceofunit");
            PriceRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String value = dataSnapshot.getValue(String.class);
                    ProductActivity.txtprice.setText(value);
                    priceofunit = value;
                    Product p = new Product(name,barcode,department,shelf,priceofunit,capacity);
                    products.add(p);
                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }
            });

    }
}
