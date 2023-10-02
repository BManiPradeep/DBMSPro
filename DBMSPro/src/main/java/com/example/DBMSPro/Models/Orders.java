package com.example.DBMSPro.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="ORDERS")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long order_id ;
    private Long user_id ;
    private Long DriverID;
    private LocalDate OrderedDate;
    private float OrderTotal;
    private LocalDate DeliveredDate;
    private String order_status ;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getDriverID() {
        return DriverID;
    }

    public void setDriverID(Long driverID) {
        DriverID = driverID;
    }

    public LocalDate getOrderedDate() {
        return OrderedDate;
    }

    public void setOrderedDate(LocalDate orderedDate) {
        OrderedDate = orderedDate;
    }

    public float getOrderTotal() {
        return OrderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        OrderTotal = orderTotal;
    }

    public LocalDate getDeliveredDate() {
        return DeliveredDate;
    }

    public void setDeliveredDate(LocalDate deliveredDate) {
        DeliveredDate = deliveredDate;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public Orders() {
    }

    public Orders(Long order_id, Long user_id, Long driverID, LocalDate orderedDate, float orderTotal, LocalDate deliveredDate, String order_status) {
        this.order_id = order_id;
        this.user_id = user_id;
        DriverID = driverID;
        OrderedDate = orderedDate;
        OrderTotal = orderTotal;
        DeliveredDate = deliveredDate;
        this.order_status = order_status;
    }

    public Orders(Long user_id, Long driverID, LocalDate orderedDate, float orderTotal, LocalDate deliveredDate, String order_status) {
        this.user_id = user_id;
        DriverID = driverID;
        OrderedDate = orderedDate;
        OrderTotal = orderTotal;
        DeliveredDate = deliveredDate;
        this.order_status = order_status;
    }
}
