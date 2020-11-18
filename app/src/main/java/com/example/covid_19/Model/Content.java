package com.example.covid_19.Model;

import android.icu.text.CaseMap;

public class Content {
    //content view
    private String Question;
    private String Ans;
    private String address;

    private String phone1;
    private String phone2;
    private String phone3;
    private String phone4;
    private String phone5;
    private String phone6;
    private String phone7;
    private String phone8;

    //Hotline view


    public Content(String phone1, String phone2, String phone3, String phone4, String phone5, String phone6, String phone7, String phone8) {
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.phone4 = phone4;
        this.phone5 = phone5;
        this.phone6 = phone6;
        this.phone7 = phone7;
        this.phone8 = phone8;
    }

    public Content() {
    }

    public Content(String question, String ans, String address) {
        Question = question;
        Ans = ans;
        address = address;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
    }

    public String getPhone4() {
        return phone4;
    }

    public void setPhone4(String phone4) {
        this.phone4 = phone4;
    }

    public String getPhone5() {
        return phone5;
    }

    public void setPhone5(String phone5) {
        this.phone5 = phone5;
    }

    public String getPhone6() {
        return phone6;
    }

    public void setPhone6(String phone6) {
        this.phone6 = phone6;
    }

    public String getPhone7() {
        return phone7;
    }

    public void setPhone7(String phone7) {
        this.phone7 = phone7;
    }

    public String getPhone8() {
        return phone8;
    }

    public void setPhone8(String phone8) {
        this.phone8 = phone8;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getQuestion() {
        return Question;
    }

    public String getAns() {
        return Ans;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public void setAns(String ans) {
        Ans = ans;
    }
}
