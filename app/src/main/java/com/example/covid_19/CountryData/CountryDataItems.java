package com.example.covid_19.CountryData;

public class CountryDataItems {

    private String countryName;
    private String totalCases;
    private String todayCase;
    private String totalDeaths;
    private String todayDeaths;
    private String totalRecovered;
    private String critical;

    public CountryDataItems(String countryName, String totalCases, String todayCase, String totalDeaths, String todayDeaths, String totalRecovered, String critical) {
        this.countryName = countryName;
        this.totalCases = totalCases;
        this.todayCase = todayCase;
        this.totalDeaths = totalDeaths;
        this.todayDeaths = todayDeaths;
        this.totalRecovered = totalRecovered;
        this.critical = critical;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(String totalCases) {
        this.totalCases = totalCases;
    }

    public String getTodayCase() {
        return todayCase;
    }

    public void setTodayCase(String todayCase) {
        this.todayCase = todayCase;
    }

    public String getTotalDeaths() {
        return totalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        this.totalDeaths = totalDeaths;
    }

    public String getTodayDeaths() {
        return todayDeaths;
    }

    public void setTodayDeaths(String todayDeaths) {
        this.todayDeaths = todayDeaths;
    }

    public String getTotalRecovered() {
        return totalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        this.totalRecovered = totalRecovered;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }
}
