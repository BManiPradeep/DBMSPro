package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.OrderItem;

import java.util.List;

public interface OrderItemRepository {
    int addOrderItem(int order_id, int product_id, int quantity);
    List<OrderItem> getOrderitemsbyOrderId(int order_id);
}
