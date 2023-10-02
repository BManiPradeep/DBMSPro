package com.example.DBMSPro.Models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long SupplierId;
    private String SupplierName;
    private String PhoneNo;
    private String Email;

    public Long getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(Long supplierId) {
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
