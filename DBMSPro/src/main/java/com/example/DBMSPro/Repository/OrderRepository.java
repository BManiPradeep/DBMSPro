package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Order;

import java.util.List;

public interface OrderRepository {
    public int addOrder(int user_id);

    public int updateOrder(Order order, int order_id);

    public List<Order> findAllOrders();

    public Order getOrderById(int order_id);
}
