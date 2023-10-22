package com.example.DBMSPro.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

public class Supplier {
    private Long SupplierId;
    private String SupplierName;
    private String PhoneNo;
    private String Email;

    public Long getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(Long supplierId) {
        if(supplierId==0){
            supplierId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        }
        SupplierId = supplierId;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Supplier() {
        this.SupplierId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }


    public Supplier(String supplierName, String phoneNo, String email) {
        SupplierName = supplierName;
        PhoneNo = phoneNo;
        Email = email;
    }

    public Supplier(Long supplierId, String supplierName, String phoneNo, String email) {
        SupplierId = supplierId;
        SupplierName = supplierName;
        PhoneNo = phoneNo;
        Email = email;
    }
}
