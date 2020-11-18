package com.example.covid_19.CallDoctor;

public class DoctorItems {

    private String doctorName, doctorPhone;

    public DoctorItems(String doctorName, String doctorPhone) {
        this.doctorName = doctorName;
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }
}
