package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public class ProductRepositoryImpl implements ProductRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public int AddProduct(Product product) {
        try {
            String sql = "INSERT INTO product (ProductName, ProductDescription, Price, StockQuantity, SupplierId, image_path) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            return jdbcTemplate.update(sql, product.getProductName(), product.getProductDescription(),
                    product.getPrice(), product.getStockQuantity(), product.getSupplierId(), product.getImage_path());
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public int DeleteProduct(int ProductId) {
        try {
            String sql = "DELETE FROM product where ProductId = ?";
            return jdbcTemplate.update(sql, ProductId);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public void incrementProductCount(Long productId, Long incrementAmount) {
        String sql = "UPDATE product SET StockQuantity = StockQuantity + ? WHERE ProductId = ?";
        jdbcTemplate.update(sql, incrementAmount, productId);
    }


    @Override
    public int UpdateProduct(Product product, int prod_id) {
        String sql = "UPDATE product SET ProductName = ?, ProductDescription = ?, Price = ?, "
                + "StockQuantity = ?, SupplierId = ?, image_path = ? "
                + "WHERE ProductId = ?";

        System.out.println("Came to Update Product");
        System.out.println(product.getProductName());
        System.out.println(product.getImage_path());

        return jdbcTemplate.update(sql,
                product.getProductName(),
                product.getProductDescription(),
                product.getPrice(),
                product.getStockQuantity(),
                product.getSupplierId(),
                product.getImage_path(),
                prod_id);
    }

    @Override
    public List<Product> ListProducts() {
        String sql = "SELECT * FROM product";
        List<Product> products = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
        return products;
    }

    @Override
    public Product GetProductById(long prod_id) {
        String sql = "SELECT * FROM product WHERE ProductId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{prod_id}, new BeanPropertyRowMapper<>(Product.class));
    }


    @Override
    public int ReduceProductQuantity(int quantity, int prod_id) {
        String sql = "UPDATE product SET StockQuantity = StockQuantity - ? WHERE ProductId = ?";
        return jdbcTemplate.update(sql, quantity, prod_id);
    }

    @Override
    public List<Product> ListAllProducts() {
        String sql = "SELECT * FROM product";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
    }

    @Override
    public List<Product> FindByNameContaining(String query) {
        String sql = "SELECT * FROM product where ProductName =?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), query);
    }

    @Override
    public List<Product> findProductsByNameStartingWith(String query) {
        query += '%';
        String sql = "SELECT * FROM product WHERE ProductName LIKE ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Product>(Product.class), query);
    }

}