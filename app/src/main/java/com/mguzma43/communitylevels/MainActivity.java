package com.mguzma43.communitylevels;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private CountyAdapter countyAdapter;

    private final List<County> countyList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);

        // adapter stuff
        this.countyAdapter = new CountyAdapter(this.countyList, this);
        recyclerView.setAdapter(this.countyAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Swiper stuff
        swipeRefreshLayout = findViewById(R.id.Swiper);
        swipeRefreshLayout.setOnRefreshListener(this::onRefresh);

        County cook = new County("Cook County", "Low", "4.60%", 87.28f, 8.4f);
        County dupage = new County("DuPage County", "Low", "4.60%", 117.13f, 8.4f);
        County kane = new County("Kane County", "Low", "3.70%", 106.31f, 5.5f);

        this.countyList.add(cook);
        this.countyList.add(dupage);
        this.countyList.add(kane);

        this.countyAdapter.notifyDataSetChanged();
    }

    // method called when refresh action
    private void onRefresh(){
//        if(isConnected()) {
//            // Here the refresh occurs
//            int originalSize = this.stockList.size();
//            this.stockList.clear();
//            this.stockAdapter.notifyItemRangeRemoved(0, originalSize);
//            // load Json file
//            this.buildStockList();
//
//
//        }
//        else{
//            this.errorDialog("No network connection detected. Try again");
//        }
        this.swipeRefreshLayout.setRefreshing(false);

    }
}