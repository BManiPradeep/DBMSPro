package com.example.DBMSPro.Models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductId")
    private Long ProductId;
    @Column(name = "ProductName")
    private String ProductName;
    @Column(name = "ProductDescription")
    private String ProductDescription;
    @Column(name = "Price")
    private Long Price;
    @Column(name = "StockQuantity")
    private Long StockQuantity;
    @Column(name = "SupplierId")
    private Long SupplierId;
    @Column(name = "ExpiryDate")
    private LocalDate ExpiryDate;

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
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
