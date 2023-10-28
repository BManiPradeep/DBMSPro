package com.example.DBMSPro.Repository;

public interface OrderItemRepository {
    int addOrderItem(int order_id, int product_id, int quantity);
}
