package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MyApp myApp;
    //fixing decimal rounding error
    private static final DecimalFormat df = new DecimalFormat("0.00");

    NumberPicker quantitySelector;

    TextView quantity;
    TextView product;
    TextView total;

    Stock pants;
    Stock shoes;
    Stock hats;

    ArrayList<Stock> currentStock;

    //call from MyApp?
    StockAdapter stockAdapter;
    //HistoryRecyclerAdapter historyAdapter = ((MyApp)getApplication()).historyAdapter;

    ListView purchaseList;

    Button buyBtn;

    Button managerBtn;

    AlertDialog.Builder builder;

    //HistoryManager historyManager = ((MyApp)getApplication()).historyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pants = ((MyApp)getApplication()).pants;
        shoes = ((MyApp)getApplication()).shoes;
        hats = ((MyApp)getApplication()).hats;

        currentStock = ((MyApp)getApplication()).currentStock;

        quantitySelector = (NumberPicker) findViewById(R.id.quantityNumberPicker);
        quantitySelector.setMaxValue(100);
        quantitySelector.setMinValue(0);

        quantity = (TextView) findViewById(R.id.selectedQuantity);
        product = (TextView) findViewById(R.id.selectedProduct);
        total = (TextView) findViewById(R.id.totalAmount);

        //should I change this to adapter view later?
        quantitySelector.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                String temp = String.valueOf(newVal);
                quantity.setText(temp);
                calculateTotalPrice(newVal);
        }
        });


        purchaseList = (ListView) findViewById(R.id.purchaseList);

        stockAdapter = new StockAdapter(currentStock, getApplicationContext());
        purchaseList.setAdapter(stockAdapter);

        purchaseList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stock listItem = (Stock) purchaseList.getItemAtPosition(position);

                ListItemClicked(listItem);

            }
        });

        buyBtn = (Button) findViewById(R.id.buyButton);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buyClicked();
                stockAdapter.notifyDataSetChanged();

            }
        });

        managerBtn = (Button) findViewById(R.id.managerButton);
        managerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent managerPanel = new Intent(MainActivity.this, ManagerPanelActivity.class);
                startActivity(managerPanel);
                stockAdapter.notifyDataSetChanged();

            }
        });

        builder = new AlertDialog.Builder(this);
    }

    //handler for Stock validation/update
    // Builder with a display message and savePurchase for the history page
    private void buyClicked() {
        if (((String) product.getText()).equals("Product Type") || ((String) quantity.getText()).equals("Quantity")){
            Toast.makeText(getApplicationContext(), "All fields are required!!!", Toast.LENGTH_LONG).show();
        }
        else {
            //checks product name and that buy amount isn't larger than current stock
            if(product.getText()==pants.productName && !(pants.itemQuantity < Integer.parseInt((String) quantity.getText()))){
                pants.itemQuantity -= Integer.parseInt((String) quantity.getText());

                //adds purchase to historyManager with savePurchase method
                ((MyApp)getApplication()).savePurchase(pants.productName, Double.parseDouble((String) total.getText()), Integer.parseInt((String) quantity.getText()));

                builder.setTitle("Thank you for your purchase!");
                builder.setMessage("Your purchase is: "+(String) quantity.getText()+" Pants. Your Total is: $"+(String) total.getText());
                builder.setCancelable(true);
                builder.setNegativeButton("OK",null);

                builder.show();

            }
            else if(product.getText()==shoes.productName && !(shoes.itemQuantity < Integer.parseInt((String) quantity.getText()) )){
                shoes.itemQuantity -= Integer.parseInt((String) quantity.getText());

                //adds purchase to historyManager with savePurchase method
                ((MyApp)getApplication()).savePurchase(shoes.productName, Double.parseDouble((String) total.getText()), Integer.parseInt((String) quantity.getText()));

                builder.setTitle("Thank you for your purchase!");
                builder.setMessage("Your purchase is: "+(String) quantity.getText()+" Shoes. Your Total is: $"+(String) total.getText());
                builder.setCancelable(true);
                builder.setNegativeButton("OK",null);

                builder.show();
            }
            else if(product.getText()==hats.productName && !(hats.itemQuantity < Integer.parseInt((String) quantity.getText()) )) {
                hats.itemQuantity -= Integer.parseInt((String) quantity.getText());

                //adds purchase to historyManager with savePurchase method
                ((MyApp)getApplication()).savePurchase(hats.productName, Double.parseDouble((String) total.getText()), Integer.parseInt((String) quantity.getText()));

                builder.setTitle("Thank you for your purchase!");
                builder.setMessage("Your purchase is: "+(String) quantity.getText()+" Hats. Your Total is: $"+(String) total.getText());
                builder.setCancelable(true);
                builder.setNegativeButton("OK",null);

                builder.show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Not Enough in Stock!!!", Toast.LENGTH_LONG).show();
            }

            clear();
        }
    }

    private void clear(){
        product.setText("Product Type");
        quantity.setText("Quantity");
        total.setText("Total");
        quantitySelector.setValue(0);
    }

    public void ListItemClicked(Stock s){
        product.setText(s.productName);

        //default textView string catch
        if(!((String) quantity.getText()).equals("Quantity")){
            String temp = (String) quantity.getText();
            calculateTotalPrice(Integer.parseInt((String) quantity.getText()));
        }

    }


    public void calculateTotalPrice(int q){

        double t=0.0;
        boolean stockCheck=false;


        if (((String) product.getText()).equals("Product Type")){
            Toast.makeText(getApplicationContext(), "Please Select a Product for an updated total.", Toast.LENGTH_SHORT).show();
        }
        else if(((String) quantity.getText()).equals("Quantity")){
            Toast.makeText(getApplicationContext(), "Please Select Quantity for an updated total.", Toast.LENGTH_SHORT).show();
        }
        else if(product.getText()==pants.productName){

            t = pants.itemPrice * Double.parseDouble((String) quantity.getText());
            total.setText(String.valueOf(df.format(t)));
            stockCheck = (pants.itemQuantity < Integer.parseInt((String) quantity.getText()) );
        }
        else if(product.getText()==shoes.productName){
            t = shoes.itemPrice * Double.parseDouble((String) quantity.getText());
            total.setText(String.valueOf(df.format(t)));
            stockCheck = (shoes.itemQuantity < Integer.parseInt((String) quantity.getText()) );
        }
        else if(product.getText()==hats.productName) {
            t = hats.itemPrice * Double.parseDouble((String) quantity.getText());
            total.setText(String.valueOf(df.format(t)));
            stockCheck = (hats.itemQuantity < Integer.parseInt((String) quantity.getText()) );
        }
        else{
            Toast.makeText(getApplicationContext(), "Error Calculating Total", Toast.LENGTH_LONG).show();
        }
        //still calculates total
        if(stockCheck){
            Toast.makeText(getApplicationContext(), "Not enough Quantity in stock!!!", Toast.LENGTH_LONG).show();
        }

    }

}