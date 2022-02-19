package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    //maybe in future add restock history too
    RecyclerView purchaseList;

    //do I move this elsewhere? - HistoryAdapter? HistoryManager?
    TextView productName;
    TextView quantity;
    TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Is this content view correct? - HistoryAdapter?
        // will this actually show all items in the recycler view - HistoryAdapter? HistoryManager?
        setContentView(R.layout.activity_history);

        //do I move this elsewhere? - HistoryAdapter? HistoryManager?
        productName = findViewById(R.id.historyProductName);
        quantity = findViewById(R.id.historyQuantity);
        total = findViewById(R.id.historyTotalCost);

        purchaseList = findViewById(R.id.historyRecyclerView);
        //need onclick for items in recyclerView
        purchaseList.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent purchaseDetailsIntent = new Intent();
            }
        });
/* this is the base adapter version

        purchaseList = (ListView) findViewById(R.id.purchaseList);

        adapter = new StockAdapter(currentStock, getApplicationContext());
        purchaseList.setAdapter(adapter);



        purchaseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stock listItem = (Stock) purchaseList.getItemAtPosition(position);

                ListItemClicked(listItem);

            }
        });
 */

    }





}