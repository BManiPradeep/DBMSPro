package com.example.DBMSPro.Repository;


import com.example.DBMSPro.Models.Cart;

import java.util.List;

public interface CartRepository {

    public int AddToCart(long prod_id, long user_id);

    public int DeleteFromCart(long prod_id, long user_id);
    public int deleteProductFromCarts(long prod_id);

    public int UpdateFromCart(long prod_id, long user_id,long quantity);
    public int UpdateItemQuantity(Cart cart,long user_id,long prod_id);
    public Cart getCartById(long user_id,long prod_id);

    public  int ClearCart(long user_id);

    public List<Cart> GetCart(long user_id);
    public int getQuantity(long prod_id,long user_id);
}
