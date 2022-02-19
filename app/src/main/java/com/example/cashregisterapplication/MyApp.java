package com.example.cashregisterapplication;

import android.app.Application;

import java.util.ArrayList;

public class MyApp extends Application {

    Stock pants;
    Stock shoes;
    Stock hats;

    //Now all activities should access the same data without referring to mainActivity
    ArrayList<Stock> currentStock;
    ArrayList<Stock> purchaseHistory;

    public MyApp() {

        pants  = new Stock("Pants", 20.44, 10);
        shoes = new Stock("Shoes", 10.44, 100);
        hats = new Stock("Hats", 5.9, 30);

        currentStock = new ArrayList<>();

        currentStock.add(pants);
        currentStock.add(shoes);
        currentStock.add(hats);

        purchaseHistory = new ArrayList<>();



    }
}
