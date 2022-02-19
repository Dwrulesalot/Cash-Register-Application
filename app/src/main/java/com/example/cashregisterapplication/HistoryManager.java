package com.example.cashregisterapplication;

import java.util.ArrayList;

public class HistoryManager {

    ArrayList<History> purchaseHistory = new ArrayList<>();;



    public void addHistory(History h){
        purchaseHistory.add(h);
    }
}
