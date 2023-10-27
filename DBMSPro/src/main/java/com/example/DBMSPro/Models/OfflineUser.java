package com.example.DBMSPro.Models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class OfflineUser {
    private LocalDate Date_purchased;
    private LocalTime Time_purchased;
    private String PhoneNumber;
    private String TabletDescription;

    public LocalDate getDate_purchased() {
        return Date_purchased;
    }

    public void setDate_purchased(LocalDate date_purchased) {
        Date_purchased = date_purchased;
    }

    public LocalTime getTime_purchased() {
        return Time_purchased;
    }

    public void setTime_purchased(LocalTime time_purchased) {
        Time_purchased = time_purchased;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getTabletDescription() {
        return TabletDescription;
    }

    public void setTabletDescription(String tabletDescription) {
        TabletDescription = tabletDescription;
    }

    public OfflineUser(String phoneNumber, String tabletDescription) {
        Date_purchased = LocalDate.now();
        Time_purchased = LocalTime.now();
        PhoneNumber = phoneNumber;
        TabletDescription = tabletDescription;
    }

    public OfflineUser() {
        Date_purchased = LocalDate.now();
        Time_purchased = LocalTime.now();
    }
}
