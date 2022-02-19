package com.example.cashregisterapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class StockAdapter extends BaseAdapter {
ArrayList<Stock> listOfStock;
Context context;

    public StockAdapter(ArrayList<Stock> listOfStock, Context context) {
        this.listOfStock = listOfStock;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listOfStock.size();
    }

    @Override
    public Object getItem(int i) {
        return listOfStock.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        //inflates the layout for each list row
        if(view ==null){
            view = LayoutInflater.from(context).
                    inflate(R.layout.stock_base_adapter_row_layout, viewGroup, false);
        }

        Stock currentItem = (Stock) getItem(i);

        // gets the TextViews
        TextView productName = view.findViewById(R.id.purchaseList_productName);
        TextView price = view.findViewById(R.id.purchaseList_price);
        TextView quantity = view.findViewById(R.id.purchaseList_quantity);

        //sets the TextViews
        productName.setText(String.valueOf(listOfStock.get(i).productName));
        price.setText("$"+String.valueOf(listOfStock.get(i).itemPrice));
        quantity.setText("Quantity: "+String.valueOf(listOfStock.get(i).itemQuantity));

        return view;

        /* from teacher's example
        view = LayoutInflater.from(context).inflate(R.layout.stock_base_adapter_row_layout,null);

        TextView productName = view.findViewById(R.id.purchaseList_productName);
        TextView price = view.findViewById(R.id.purchaseList_price);
        TextView quantity = view.findViewById(R.id.purchaseList_quantity);


        productName.setText(String.valueOf(listOfStock.get(i).productName));
        price.setText(String.valueOf(listOfStock.get(i).itemPrice));
        quantity.setText(String.valueOf(listOfStock.get(i).itemQuantity));

        return view;
        */
    }
}
