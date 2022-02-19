package com.example.cashregisterapplication;

public class Stock {
    String productName;
    double itemPrice;
    int itemQuantity;

    public Stock(String product, double price, int quantity){
        this.productName = product;
        this.itemPrice = price;
        this.itemQuantity = quantity;
    }
}
