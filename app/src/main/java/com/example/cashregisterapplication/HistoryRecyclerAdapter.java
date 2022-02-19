package com.example.cashregisterapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryRecyclerAdapter extends RecyclerView.Adapter<HistoryRecyclerAdapter.HistoryViewHolder> {

    ArrayList<History> historyArrayList;
    Context context;

    public HistoryRecyclerAdapter(ArrayList<History> historyArrayList, Context context) {
        this.historyArrayList = historyArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.history_item_layout, parent, false);
        return new HistoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.productName.setText(historyArrayList.get(position).productName);
        holder.quantity.setText(String.valueOf(historyArrayList.get(position).quantity));
        holder.total.setText(String.valueOf(historyArrayList.get(position).totalCost));
    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }


    public static class HistoryViewHolder extends RecyclerView.ViewHolder{

    TextView productName;
    TextView quantity;
    TextView total;

        public HistoryViewHolder(@NonNull View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.historyProductName);
            quantity = itemView.findViewById(R.id.historyQuantity);
            total = itemView.findViewById(R.id.historyTotalCost);
        }

        public TextView getProductName() {
            return productName;
        }

        public TextView getQuantity() {
            return quantity;
        }

        public TextView getTotal() {
            return total;
        }
    }



}
