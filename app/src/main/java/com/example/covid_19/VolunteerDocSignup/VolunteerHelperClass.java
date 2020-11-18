package com.example.covid_19.VolunteerDocSignup;

public class VolunteerHelperClass {

    String name,workPlace,docPhone,email;

    public VolunteerHelperClass(String name, String workPlace, String docPhone, String email) {
        this.name = name;
        this.workPlace = workPlace;
        this.docPhone = docPhone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getDocPhone() {
        return docPhone;
    }

    public void setDocPhone(String docPhone) {
        this.docPhone = docPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
