package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartRepositoryImpl implements CartRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public int AddToCart(long prod_id, long user_id) {
        try{
            return jdbcTemplate.update("INSERT INTO cart_details (user_id, prod_id) VALUES(?,?)"
                    ,user_id,prod_id ) ;
        }
        catch (Exception e) 
        {
            return jdbcTemplate.update("UPDATE cart_details SET prod_quantity = prod_quantity +? WHERE user_id = ? AND prod_id = ?",
                    1,user_id, prod_id);
        }
    }

    @Override
    public int DeleteFromCart(long prod_id, long user_id) {
        try{
            return jdbcTemplate.update("DELETE FROM cart_details WHERE prod_id = ? AND user_id = ?", prod_id, user_id) ;
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int UpdateFromCart(long prod_id,long user_id,long quantity) {
        try {
            return jdbcTemplate.update("UPDATE cart_details SET prod_quantity = ? WHERE user_id = ? AND prod_id = ?",
                    quantity, prod_id,user_id);
        } catch (Exception e) {
            return 0;
        }
    }
    @Override
    public int UpdateItemQuantity( Cart cart, long user_id, long prod_id) {
        try {
            return jdbcTemplate.update("UPDATE cart_details SET prod_quantity=? WHERE user_id=? AND prod_id=?",
                    new Object[]{cart.getProd_quantity(),user_id,prod_id});
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int ClearCart(long user_id) {
        return jdbcTemplate.update("DELETE FROM cart_details WHERE user_id=?", user_id);
    }

    @Override
    public List<Cart> GetCart(long user_id) {

        return jdbcTemplate.query("SELECT * FROM cart_details WHERE user_id=?"
                ,new BeanPropertyRowMapper<Cart>(Cart.class),user_id);

    }

    @Override
    public Cart getCartById(long user_id,long prod_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM cart_details WHERE user_id=? AND prod_id=?",
                new BeanPropertyRowMapper<Cart>(Cart.class),user_id,prod_id);
    }

    @Override
    public int deleteProductFromCarts(long prod_id){
        return jdbcTemplate.update("DELETE FROM cart_details where prod_id=?",prod_id);
    }

    @Override
    public int getQuantity(long prod_id, long user_id) {
        int quantity = jdbcTemplate.queryForObject("SELECT prod_quantity FROM cart_details where prod_id=? AND user_id=?",
                Integer.class,prod_id,user_id);
        return quantity;
    }

    @Override
    public void UpdateCart(long productId, long id) {
        jdbcTemplate.update("UPDATE cart_details SET prod_quantity = prod_quantity +? WHERE user_id = ? AND prod_id = ?",
                5,id, productId);
    }

    @Override
    public void DecreaseItem(long productId, long id) {

        jdbcTemplate.update("UPDATE cart_details SET prod_quantity = prod_quantity -? WHERE user_id = ? AND prod_id = ?",
                1,id, productId);
    }
}
