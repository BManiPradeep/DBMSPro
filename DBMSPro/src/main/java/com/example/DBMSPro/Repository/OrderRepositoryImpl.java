package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements  OrderRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

//    @Override
//    public int addOrder(int user_id) {
//        try{
//            return jdbcTemplate.update("INSERT INTO orders(user_id) VALUES (?)",user_id);
//        } catch (Exception e) {
//            return 0;
//        }
//    }

    @Override
    public int addOrder(int user_id,String Address,long TotalPrice) {
        KeyHolder keyHolder = new GeneratedKeyHolder(); // Create a KeyHolder to retrieve generated keys

        try {
            LocalDate OrderedDate=LocalDate.now();
            jdbcTemplate.update(con -> {
                PreparedStatement ps = con.prepareStatement("INSERT INTO orders(user_id,Address,TotalPrice,Ordered_Date) VALUES (?,?,?,?)", new String[]{"order_id"});
                ps.setInt(1, user_id);
                ps.setString(2, Address);
                ps.setLong(3,TotalPrice);
                ps.setDate(4, Date.valueOf(OrderedDate));
                return ps;
            }, keyHolder);
            // Access the generated ID
            return keyHolder.getKey().intValue();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int updateOrder(Order order, int order_id) {
        try{
            return jdbcTemplate.update("UPDATE orders SET emp_id=?,order_status=? WHERE order_id=?",order.getEmp_id(),
                    order.getOrder_status(),order_id);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public List<Order> findAllOrders() {
        return jdbcTemplate.query("SELECT * FROM orders ",
                new BeanPropertyRowMapper<Order>(Order.class));
    }

    @Override
    public Order getOrderById(int order_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM orders WHERE order_id=? ",
                new BeanPropertyRowMapper<Order>(Order.class),order_id);
    }

    @Override
    public List<Order> getOrdersByUserId(int id) {
        return jdbcTemplate.query("SELECT * FROM orders WHERE user_id = ?", new BeanPropertyRowMapper<Order>(Order.class),id);
    }


}
