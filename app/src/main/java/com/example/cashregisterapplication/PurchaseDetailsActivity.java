package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class PurchaseDetailsActivity extends AppCompatActivity {

    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

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

    }

}