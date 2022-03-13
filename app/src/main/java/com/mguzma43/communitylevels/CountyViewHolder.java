package com.mguzma43.communitylevels;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class CountyViewHolder extends RecyclerView.ViewHolder {

    TextView countyName;
    TextView communityLevel;
    TextView cases;
    TextView hospitalization;
    TextView bedUsage;

    CountyViewHolder(View view){
        super(view);
        this.countyName = view.findViewById(R.id.countyNameView);
        this.communityLevel = view.findViewById(R.id.communityLevelView);
        this.cases = view.findViewById(R.id.casesView);
        this.hospitalization = view.findViewById(R.id.hospitalizationView);
        this.bedUsage = view.findViewById(R.id.bedPercentageView);
    }
}
