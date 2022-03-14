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
    private CountyDownloader countyDownloader;

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

        this.BuildCountyList();
    }

    private void BuildCountyList(){
        ArrayList<String> fips = new ArrayList<>();
        fips.add("17031"); // cook county
        fips.add("17043"); // dupage county
        fips.add("17089"); // kane county
//        fips.add("17091"); // for testing

        for(String county : fips){
            countyDownloader = new CountyDownloader(this, county);
            new Thread(countyDownloader).start();
        }
    }

    public void UpdateData(County county){
        this.countyList.add(county);
        this.countyAdapter.notifyItemInserted(this.countyList.size() - 1);
        this.countyList.sort((county1, county2) -> county1.getCountyName().compareTo(county2.getCountyName()));
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