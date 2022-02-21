package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity {

    Stock pants;
    Stock shoes;
    Stock hats;

    boolean listItemSelected;
    Stock stockToRestock;

    EditText userInput;

    Button btnOk;
    Button btnCancel;

    ListView stockListView;
    ArrayList<Stock> currentStock;

    StockAdapter restockAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);

        userInput = (EditText) findViewById(R.id.restockQuantityUserInput);

        //default stock
        stockToRestock = new Stock("", 0.0, 0);

        pants = ((MyApp)getApplication()).pants;
        shoes = ((MyApp)getApplication()).shoes;
        hats = ((MyApp)getApplication()).hats;

        btnOk = (Button) findViewById(R.id.restockOkButton);
        btnOk.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                restockClicked();
                restockAdapter.notifyDataSetChanged();
            }
        });

        btnCancel = (Button) findViewById(R.id.restockCancelButton);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        //does this make sense? two lists with the same I.id.name
        stockListView = (ListView) findViewById(R.id.purchaseList);

        currentStock = ((MyApp)getApplication()).currentStock;

        restockAdapter = new StockAdapter(currentStock, getApplicationContext());
        stockListView.setAdapter(restockAdapter);

        stockListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Stock listItem = (Stock) stockListView.getItemAtPosition(position);

                if(listItemSelected){
                    //unselect / highlight?
                    listItemSelected = false;
                    stockToRestock = new Stock("", 0.0, 0);
                }
                else{
                    listItemClicked(listItem);
                    //highlight
                }

            }
        });

    }

    public void restockClicked(){

        //if empty/stock item not selected
        if (stockToRestock.productName.equals("") || !listItemSelected){
            Toast.makeText(getApplicationContext(), "Please select a product to restock from the list.", Toast.LENGTH_SHORT).show();
        }
        //if editText is empty/not a number?
        // does this mean it's still a string of numbers or diff data type?
        else if(userInput.getText().equals("")){
            Toast.makeText(getApplicationContext(), "Please enter the quantity of items you'd like to Restock.", Toast.LENGTH_SHORT).show();
        }
        else if(stockToRestock.productName.equals("Pants") && listItemSelected ){
            pants.itemQuantity += Integer.parseInt(String.valueOf(userInput.getText()));
            //do I need to make new function to update the current stock/individual stocks?

        }
        else if(stockToRestock.productName.equals("Hats") && listItemSelected) {
            hats.itemQuantity += Integer.parseInt(String.valueOf(userInput.getText()));
        }
        else if(stockToRestock.productName.equals("Shoes") && listItemSelected){
            shoes.itemQuantity += Integer.parseInt(String.valueOf(userInput.getText()));
        }
        else{
            Toast.makeText(getApplicationContext(), "Error! did not complete Restocking.", Toast.LENGTH_SHORT).show();
        }

    }

    public void listItemClicked(Stock stock){
        listItemSelected = true;
        stockToRestock = stock;
    }

}