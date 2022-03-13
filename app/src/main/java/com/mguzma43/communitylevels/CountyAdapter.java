package com.mguzma43.communitylevels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountyAdapter extends RecyclerView.Adapter<CountyViewHolder> {

    private final List<County> countyList;
    private final MainActivity mainActivity;

    CountyAdapter(List<County> countyList, MainActivity main){
        this.countyList = countyList;
        this.mainActivity = main;
    }

    @NonNull
    @Override
    public CountyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View countyView = LayoutInflater.from(parent.getContext()).inflate(R.layout.county_layout, parent, false);

        // Add if I want to do something with clicking
        //countyView.setOnClickListener(this.mainActivity);
        //countyView.setOnLongClickListener(this.mainActivity);

        return new CountyViewHolder(countyView);
    }

    @Override
    public void onBindViewHolder(@NonNull CountyViewHolder holder, int position) {
        County county = this.countyList.get(position);

        // example
        //holder.stockSymbol.setText(stock.getStockSymbol());
    }

    @Override
    public int getItemCount() {
        return this.countyList.size();
    }
}