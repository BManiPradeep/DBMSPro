package com.example.DBMSPro.Models;

import jakarta.persistence.*;

@Entity
@Table(name="DELIVERYPARTNER")
public class DeliveryPartner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long DriverId;
    private String DFname;
    private String DLname;
    private float Rating;
    private String PhoneNo;

    public Long getDriverId() {
        return DriverId;
    }

    public void setDriverId(Long driverId) {
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
    }

    public DeliveryPartner(String DFname, String DLname, float rating, String phoneNo) {
        this.DFname = DFname;
        this.DLname = DLname;
        Rating = rating;
        PhoneNo = phoneNo;
    }

}
