package com.example.cashregisterapplication;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.activity.result.ActivityResultLauncher;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyApp extends Application {

    Stock pants;
    Stock shoes;
    Stock hats;

    //Now all activities should access the same data without referring to mainActivity
    ArrayList<Stock> currentStock;
    HistoryManager historyManager;


    public MyApp() {

        pants  = new Stock("Pants", 20.44, 10);
        shoes = new Stock("Shoes", 10.44, 100);
        hats = new Stock("Hats", 5.9, 30);

        currentStock = new ArrayList<>();
        historyManager = new HistoryManager();

        currentStock.add(pants);
        currentStock.add(shoes);
        currentStock.add(hats);

    }

    //todo do I need to make this update quantity for both mainActivity and restockActivity adapters?
    //creates a history object and adds it to historyManager's array purchaseHistory
    public void savePurchase(String productName, double totalCost, int quantity){

        Date date = new Date();
        Log.d("Ass2", "MyApp.savePurchase() "+productName+" "+String.valueOf(totalCost)+" "+String.valueOf(quantity)+" "+String.valueOf(date));
        History history = new History(productName, totalCost, quantity, date);

        historyManager.addHistory(history);
    }


}
