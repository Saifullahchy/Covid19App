package com.example.covid_19.gov_hospital;

public class GovHospotalItems {

    String hospitalName;
    String hospitalAdd;
    String hospitalCont;

    public GovHospotalItems(String hospitalName, String hospitalAdd, String hospitalCont) {
        this.hospitalName = hospitalName;
        this.hospitalAdd = hospitalAdd;
        this.hospitalCont = hospitalCont;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAdd() {
        return hospitalAdd;
    }

    public void setHospitalAdd(String hospitalAdd) {
        this.hospitalAdd = hospitalAdd;
    }

    public String getHospitalCont() {
        return hospitalCont;
    }

    public void setHospitalCont(String hospitalCont) {
        this.hospitalCont = hospitalCont;
    }
}
