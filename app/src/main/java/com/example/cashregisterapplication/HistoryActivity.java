package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    //maybe in future add restock history too
    RecyclerView purchaseList;

    //do I move this elsewhere? - HistoryAdapter?
    TextView productName;
    TextView quantity;
    TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Is this content view correct? - HistoryAdapter?
        // will this actually show all items in the recycler view - HistoryAdapter?
        setContentView(R.layout.activity_history);

        purchaseList = findViewById(R.id.historyRecyclerView);

        //do I move this elsewhere? - HistoryAdapter?
        productName = findViewById(R.id.historyProductName);
        quantity = findViewById(R.id.historyQuantity);
        total = findViewById(R.id.historyTotalCost);

    }




}