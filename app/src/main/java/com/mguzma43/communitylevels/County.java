package com.mguzma43.communitylevels;

public class County {

    private String countyName;
    private String communityLevel;
    private String bedUtilization;
    private double cases;
    private double hospitalAdmission;

    County(String countyName, String communityLevel, String bedUtilization, double cases, double hospitalAdmission){
        this.countyName = countyName;
        this.communityLevel = communityLevel;
        this.bedUtilization = bedUtilization;
        this.cases = cases;
        this.hospitalAdmission = hospitalAdmission;
    }

    public String getCountyName(){ return this.countyName; }

    public String getCommunityLevel(){ return this.communityLevel; }

    public String getBedUtilization(){ return this.bedUtilization; }

    public double getCases(){ return this.cases; }

    public double getHospitalAdmission(){ return this.hospitalAdmission; }
}
