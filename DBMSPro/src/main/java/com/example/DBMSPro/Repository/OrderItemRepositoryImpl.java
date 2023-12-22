package com.example.DBMSPro.Repository;


import com.example.DBMSPro.Models.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addOrderItem(int order_id, int product_id, int quantity) {
        String sql="INSERT INTO order_item(orderId,productId,quantity) VALUES(?,?,?)";
        try {
            return jdbcTemplate.update(sql,order_id,product_id,quantity);
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public List<OrderItem> getOrderitemsbyOrderId(int order_id) {
        String sql = "SELECT  *  FROM order_item WHERE OrderId = ?";

        return jdbcTemplate.query(sql, new Object[]{order_id}, (rs, rowNum) -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId((long) order_id);
//            orderItem.setOrderItemId(rs.getLong("order_item_id"));
            orderItem.setProductId(rs.getLong("ProductId"));
            orderItem.setQuantity(rs.getLong("Quantity"));
            return orderItem;
        });

    }
}
