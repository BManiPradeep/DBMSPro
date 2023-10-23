package com.example.DBMSPro.Models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

public class Product {
    private Long ProductId;
    private String ProductName;
    private String ProductDescription;
    private Long Price;
    private Long StockQuantity;
    private Long SupplierId;
    private String image_path;



    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        if(productId==0){
            productId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        }
        this.ProductId = productId;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getProductDescription() {
        return ProductDescription;
    }

    public void setProductDescription(String productDescription) {
        this.ProductDescription = productDescription;
    }

    public Long getPrice() {
        return Price;
    }

    public void setPrice(Long price) {
        this.Price = price;
    }

    public Long getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(Long stockQuantity) {
        this.StockQuantity = stockQuantity;
    }

    public Long getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.SupplierId = supplierId;
    }

    public Product() {
        this.ProductId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Product(String productName, String productDescription, Long price, Long stockQuantity, Long supplierId, LocalDate expiryDate,String image_path) {
        this.ProductName = productName;
        this.ProductDescription = productDescription;
        this.Price = price;
        this.StockQuantity = stockQuantity;
        this.SupplierId = supplierId;
        this.image_path=image_path;
    }
    public Product(Long productId, String productName, String productDescription, Long price, Long stockQuantity, Long supplierId, LocalDate expiryDate,String image_path) {
        this.ProductId = productId;
        this.ProductName = productName;
        this.ProductDescription = productDescription;
        this.Price = price;
        this.StockQuantity = stockQuantity;
        this.SupplierId = supplierId;
        this.image_path=image_path;
    }

}
