package com.example.DBMSPro.Models;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class Order {

    private int order_id ;
    private int user_id ;
    private int emp_id ;
    private String Address;
    private String order_status ;
    private long TotalPrice;
    private LocalDate Ordered_Date;


    public Order(int order_id, int user_id, int emp_id, String address, String order_status, long totalPrice) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.emp_id = emp_id;
        Address = address;
        this.order_status = order_status;
        TotalPrice = totalPrice;
        this.Ordered_Date=LocalDate.now();
    }

    public Order( int user_id, int emp_id, String address, String order_status, long totalPrice) {
        this.user_id = user_id;
        this.emp_id = emp_id;
        Address = address;
        this.order_status = order_status;
        TotalPrice = totalPrice;
        this.Ordered_Date=LocalDate.now();
    }

//    public int getOrder_id() {
//        return order_id;
//    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
//    public int getUser_id() {
//        return user_id;
//    }
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
//    public int getEmp_id() {
//        return emp_id;
//    }
    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }
//    public String getOrder_status() {
//        return order_status;
//    }
    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }


    public void setAddress(String address) {
        Address = address;
    }

    public void setTotalPrice(long totalPrice) {
        TotalPrice = totalPrice;
    }

    public void setOrdered_Date(LocalDate ordered_Date) {
        Ordered_Date = ordered_Date;
    }
}
