package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Product;

import java.util.List;

public interface ProductRepository {

    public int AddProduct(Product product);

    public int DeleteProduct(int prod_id);

    public int UpdateProduct(Product product, int prod_id);

    public List<Product> ListProducts();
    public void incrementProductCount(Long productId, Long incrementAmount);

    public Product GetProductById(int prod_id);

    public int ReduceProductQuantity(int quantity, int prod_id);

    public List<Product> ListAllProducts();

}