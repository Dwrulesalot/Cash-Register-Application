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

    //Getters & Setters
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
