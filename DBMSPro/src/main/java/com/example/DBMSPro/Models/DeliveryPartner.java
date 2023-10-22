package com.example.DBMSPro.Models;

import jakarta.persistence.*;

import java.util.UUID;

public class DeliveryPartner {
    private Long DriverId;
    private String DFname;
    private String DLname;
    private float Rating;
    private String PhoneNo;

    public Long getDriverId() {
        return DriverId;
    }

    public void setDriverId(Long driverId) {
        if(driverId==0){
            driverId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        }
        DriverId = driverId;
    }

    public String getDFname() {
        return DFname;
    }

    public void setDFname(String DFname) {
        this.DFname = DFname;
    }

    public String getDLname() {
        return DLname;
    }

    public void setDLname(String DLname) {
        this.DLname = DLname;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float rating) {
        Rating = rating;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public DeliveryPartner(Long driverId, String DFname, String DLname, float rating, String phoneNo) {
        DriverId = driverId;
        this.DFname = DFname;
        this.DLname = DLname;
        Rating = rating;
        PhoneNo = phoneNo;
    }

    public DeliveryPartner() {
        this.DriverId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public DeliveryPartner(String DFname, String DLname, float rating, String phoneNo) {
        this.DFname = DFname;
        this.DLname = DLname;
        Rating = rating;
        PhoneNo = phoneNo;
    }

}
