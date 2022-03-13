package com.mguzma43.communitylevels;

public class County {

    private String countyName;
    private String communityLevel;
    private String bedUtilization;
    private float cases;
    private float hospitalAdmission;

    County(String countyName, String communityLevel, String bedUtilization, float cases, float hospitalAdmission){
        this.countyName = countyName;
        this.communityLevel = communityLevel;
        this.bedUtilization = bedUtilization;
        this.cases = cases;
        this.hospitalAdmission = hospitalAdmission;
    }

    public String getCountyName(){ return this.countyName; }

    public String getCommunityLevel(){ return this.communityLevel; }

    public String getBedUtilization(){ return this.bedUtilization; }

    public float getCases(){ return this.cases; }

    public float getHospitalAdmission(){ return this.hospitalAdmission; }
}
