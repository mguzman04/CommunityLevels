package com.mguzma43.communitylevels;

import android.net.Uri;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class CountyDownloader implements Runnable{

    private final MainActivity mainActivity;
    private final String countyFips;
    private static final String apiURL = "https://data.cdc.gov/resource/3nnm-4jni.json";

    CountyDownloader(MainActivity mainActivity, String countyFips){
        this.mainActivity = mainActivity;
        this.countyFips = countyFips;
    }

    @Override
    public void run() {
        Uri.Builder buildURL = Uri.parse(apiURL).buildUpon();

        // Example for Cook County, IL
        //https://data.cdc.gov/resource/3nnm-4jni.json?county_fips=17031
        buildURL.appendQueryParameter("county_fips", countyFips);
        String urlToUse = buildURL.build().toString();

        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlToUse);

            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            connection.connect();

            if (connection.getResponseCode() != HttpsURLConnection.HTTP_OK) {
                handleResults(null);
                return;
            }

            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader((new InputStreamReader(is)));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }


        } catch (Exception e) {
            handleResults(null);
            return;
        }

        handleResults(sb.toString());

    }

    public void handleResults(final String jsonString) {

        final County county = parseJSON(jsonString);
        mainActivity.runOnUiThread(() -> {
                mainActivity.UpdateData(county);
        });
    }

    private County parseJSON(String s){
        try {
            JSONArray jsonArray = new JSONArray(s);
            int size = jsonArray.length();
            // use last array to get most resent data
            JSONObject jsonObject = jsonArray.getJSONObject(size - 1);

            String countyName = jsonObject.getString("county");
            String communityLevel = jsonObject.getString("covid_19_community_level");
            String bedUtilization = jsonObject.getString("covid_inpatient_bed_utilization");
            double cases = jsonObject.getDouble("covid_cases_per_100k");
            double hospitalAdmission = jsonObject.getDouble("covid_hospital_admissions_per_100k");

            return new County(countyName, communityLevel, bedUtilization, cases, hospitalAdmission);

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
