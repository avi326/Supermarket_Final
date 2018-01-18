package com.example.meravdor.supermarket;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MyListActivity extends Activity {
    private Firebase DepartmentRef;
    private Firebase ShelfRef;
    private Firebase BarcodeRef;
    private Firebase PriceRef;
    private Firebase CapacityRef;
    private Firebase NameRef;
//    ListView listViewProducts;

    String name;
    String barcode;
    String department;
    String shelf;
    String priceofunit;
    String capacity;


    private ListView mainListView ;
    private ArrayAdapter<String> adapter ;
    //a list to store all the artist from firebase database
//    ArrayList<Product> products;
//    Product p ;
    //our database reference object
    DatabaseReference databaseProduts;
    Product p = new Product();
//    final ArrayList<Product> productList = new ArrayList<Product>();

//    Product p;
    boolean yes = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);

        mainListView = (ListView) findViewById(R.id.listViewProducts);
        final ArrayList<String> productList = new ArrayList<String>();
//        p = new Product();
        databaseProduts = FirebaseDatabase.getInstance().getReference("Products");



        boolean check1 = listOfProActivity.box.isChecked();
        boolean check2 = listOfProActivity.box2.isChecked();
            if (check1) {
                productList.add(listOfProActivity.productList2.get(0));
                adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, productList);
                mainListView.setAdapter(adapter);
            }
             if(check2){
                productList.add(listOfProActivity.productList2.get(1));
//
                adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, productList);
                mainListView.setAdapter(adapter);
            }
            if(!check1 && !check2){
                Toast.makeText(this,"No products selected",Toast.LENGTH_SHORT).show();
            }
    }
}
