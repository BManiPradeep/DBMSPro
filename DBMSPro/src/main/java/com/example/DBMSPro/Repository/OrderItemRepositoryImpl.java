package com.example.DBMSPro.Repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
}
