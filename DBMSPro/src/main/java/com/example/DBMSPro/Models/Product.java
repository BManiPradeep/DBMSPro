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
    private LocalDate ExpiryDate;

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        if(productId==0){
            productId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        }
        this.ProductId = productId;
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

    public LocalDate getExpiryDate() {
        return ExpiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.ExpiryDate = expiryDate;
    }

    public Product() {
        this.ProductId=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

    public Product(String productName, String productDescription, Long price, Long stockQuantity, Long supplierId, LocalDate expiryDate) {
        this.ProductName = productName;
        this.ProductDescription = productDescription;
        this.Price = price;
        this.StockQuantity = stockQuantity;
        this.SupplierId = supplierId;
        this.ExpiryDate = expiryDate;
    }
    public Product(Long productId, String productName, String productDescription, Long price, Long stockQuantity, Long supplierId, LocalDate expiryDate) {
        this.ProductId = productId;
        this.ProductName = productName;
        this.ProductDescription = productDescription;
        this.Price = price;
        this.StockQuantity = stockQuantity;
        this.SupplierId = supplierId;
        this.ExpiryDate = expiryDate;
    }

}
