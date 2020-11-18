package com.example.covid_19.CallNationalHelpLine;

public class helplineItem {

    private String helplineAddress;
    private String helplineNumber;

    public helplineItem(String helplineAddress, String helplineNumber) {
        this.helplineAddress = helplineAddress;
        this.helplineNumber = helplineNumber;
    }

    public String getHelplineAddress() {
        return helplineAddress;
    }

    public void setHelplineAddress(String helplineAddress) {
        this.helplineAddress = helplineAddress;
    }

    public String getHelplineNumber() {
        return helplineNumber;
    }

    public void setHelplineNumber(String helplineNumber) {
        this.helplineNumber = helplineNumber;
    }
}
