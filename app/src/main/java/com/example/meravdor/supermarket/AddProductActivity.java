package com.example.meravdor.supermarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddProductActivity extends AppCompatActivity {

    private EditText etProductName,etBarcode,etDepartment,etShelf,etCapacity,etPrice;
    private String  product,barcode,depart,shelf,capa,price;
    Button bAdd;

    private Firebase mRootRef;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        Firebase.setAndroidContext(this);
        mRootRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Products");

        etProductName = (EditText) findViewById(R.id.productname);
        etBarcode = (EditText) findViewById(R.id.idname);
        etDepartment = (EditText) findViewById(R.id.Department);
        etShelf = (EditText) findViewById(R.id.Shelf);
        etCapacity = (EditText) findViewById(R.id.Capacity);
        etPrice = (EditText) findViewById(R.id.Price);
        bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = etProductName.getText().toString().trim();
                barcode = etBarcode.getText().toString().trim();
                depart = etDepartment.getText().toString().trim();
                shelf = etShelf.getText().toString().trim();
                price = etPrice.getText().toString().trim();
                capa = etCapacity.getText().toString().trim();




                boolean vaild = true;
                if (product.isEmpty()||product.length()>32){
                    etProductName.setError("Please enter vaild product name");
                    vaild = false;
                }
                else if (barcode.isEmpty()||barcode.length()>32){
                    etBarcode.setError("Please enter vaild barcode");
                    vaild = false;
                }
                else if(depart.isEmpty()||depart.length()>32){
                    etDepartment.setError("Please enter vaild department");
                    vaild = false;
                }
                else if(shelf.isEmpty()||shelf.length()>32){
                    etShelf.setError("Please enter vaild shelf");
                    vaild = false;
                }
                else if(price.isEmpty()||price.length()>32){
                    etPrice.setError("Please enter vaild price");
                    vaild = false;
                }
                else if(capa.isEmpty()||capa.length()>32){
                    etCapacity.setError("Please enter vaild capacity");
                    vaild = false;
                }
                else {

                    databaseReference = FirebaseDatabase.getInstance().getReference("Products");
                    String id = mRootRef.push().getKey();

                    Product pro = new Product(product,barcode,depart,shelf,capa,price);
                    id = pro.getName();
                    mRootRef.child(id).setValue(pro);

                    Intent i = new Intent(AddProductActivity.this,MenuProductActivity.class);
                    startActivity(i);
                }
            }

        });



    }
    }

