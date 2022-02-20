package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class PurchaseDetailsActivity extends AppCompatActivity {

    TextView product;
    TextView total;
    TextView date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_details);

        product = (TextView) findViewById(R.id.detailsProductName);
        total = (TextView) findViewById(R.id.detailsPurchasePrice);
        date = (TextView) findViewById(R.id.detailsPurchaseDate);

        product.setText("Product: "+getIntent().getStringExtra("product"));
        total.setText("Total Cost: $"+getIntent().getStringExtra("total"));
        date.setText("Date: "+getIntent().getStringExtra("date"));
    }
}