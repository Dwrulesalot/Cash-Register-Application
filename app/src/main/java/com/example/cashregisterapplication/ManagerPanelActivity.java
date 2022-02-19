package com.example.cashregisterapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerPanelActivity extends AppCompatActivity {

    Button historyBtn;
    Button restockBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);

        historyBtn = findViewById(R.id.historyButton);
        historyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent managerPanel = new Intent(ManagerPanelActivity.this, HistoryActivity.class);
                startActivity(managerPanel);
                //where do I grab the adapters from?
                //adapter.notifyDataSetChanged();

            }
        });



        restockBtn = findViewById(R.id.restockButton);
        restockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent managerPanel = new Intent(ManagerPanelActivity.this, RestockActivity.class);
                startActivity(managerPanel);
                //where do I grab the adapters from?
                //adapter.notifyDataSetChanged();

            }
        });
    }
}
