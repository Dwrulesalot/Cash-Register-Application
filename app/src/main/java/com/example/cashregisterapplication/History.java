package com.example.cashregisterapplication;

import java.util.Date;

public class History {
    String productName;
    double totalCost;
    int quantity;
    //Date for HistoryDetails page
    Date purchaseDate;

    public History(String productName, double totalCost, int quantity, Date purchaseDate) {
        this.productName = productName;
        this.totalCost = totalCost;
        this.quantity = quantity;
        this.purchaseDate = purchaseDate;
    }
}
