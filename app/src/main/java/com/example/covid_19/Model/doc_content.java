package com.example.covid_19.Model;

public class doc_content {
    private String Name;
    private String phone;


    public doc_content() {

    }

    public doc_content(String name, String phone) {
        Name = name;
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
