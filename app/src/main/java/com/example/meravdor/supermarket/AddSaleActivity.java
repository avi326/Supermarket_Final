package com.example.meravdor.supermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.Firebase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddSaleActivity extends AppCompatActivity {

    private EditText etProductName,etPrice;
    private String  product, price;
    Button bAdd;

    private Firebase mRootRef;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_sale);

        Firebase.setAndroidContext(this);
        mRootRef=new Firebase("https://supermarket-8ae61.firebaseio.com/Sales");

        etProductName = (EditText) findViewById(R.id.productname);
        etPrice = (EditText) findViewById(R.id.Price);
        bAdd = (Button) findViewById(R.id.bAdd);

        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                product = etProductName.getText().toString().trim();
                price = etPrice.getText().toString().trim();


                boolean vaild = true;
                if (product.isEmpty()||product.length()>32){
                    etProductName.setError("Please enter vaild product name");
                    vaild = false;
                }

                else if(price.isEmpty()||price.length()>32){
                    etPrice.setError("Please enter vaild price");
                    vaild = false;
                }

                else {

                    databaseReference = FirebaseDatabase.getInstance().getReference("Sales");
                    String id = mRootRef.push().getKey();

                    Sale sale = new Sale(product,price);
                    id = sale.getNameofproduct();
                    mRootRef.child(id).setValue(sale);

                    Intent i = new Intent(AddSaleActivity.this,SalesActivity.class);
                    startActivity(i);
                }
            }

        });



    }

}
