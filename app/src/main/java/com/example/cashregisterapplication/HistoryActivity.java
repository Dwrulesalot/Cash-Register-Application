package com.example.cashregisterapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.Date;

public class HistoryActivity extends AppCompatActivity{

    //maybe in future add restock history too
    RecyclerView purchaseList;

    HistoryRecyclerAdapter historyAdapter;

    HistoryManager historyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        purchaseList = (RecyclerView) findViewById(R.id.historyRecyclerView);
        historyManager  = ((MyApp)getApplication()).historyManager;

        //adapter to grabs historyManager.(ArrayList<History>)purchaseHistory from MyApp
        historyAdapter = new HistoryRecyclerAdapter(historyManager.purchaseHistory, this);
        purchaseList.setAdapter(historyAdapter);
        purchaseList.setLayoutManager(new LinearLayoutManager(this));

    }

}