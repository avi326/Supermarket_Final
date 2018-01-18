package com.example.meravdor.supermarket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_product);

        final Button buttonList = findViewById(R.id.buttonList);
        buttonList.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(MenuProductActivity.this,listOfProActivity.class);
                startActivity(i);
            }
        });
        final Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(MenuProductActivity.this,AddProductActivity.class);
                startActivity(i);
            }
        });

        final Button buttonSales = findViewById(R.id.buttonSales);
        buttonSales.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(MenuProductActivity.this,SalesActivity.class);
                startActivity(i);
            }
        });
        final Button buttonAddSales = findViewById(R.id.buttonAddSales);
        buttonAddSales.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Code here executes on main thread after user presses button
                Intent i = new Intent(MenuProductActivity.this,AddSaleActivity.class);
                startActivity(i);
            }
        });

    }
}
