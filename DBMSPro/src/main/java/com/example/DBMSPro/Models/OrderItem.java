package com.example.DBMSPro.Models;

import jakarta.persistence.*;

@Entity
@Table(name="ORDERITEM")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ItemId;
    private Long OrderId;
    private Long ProductId;
    private Long Quantity;
    private float UnitPrice;

    public OrderItem() {
    }

    public OrderItem(Long itemId, Long orderId, Long productId, Long quantity, float unitPrice) {
        ItemId = itemId;
        OrderId = orderId;
        ProductId = productId;
        Quantity = quantity;
        UnitPrice = unitPrice;
    }

    public OrderItem(Long orderId, Long productId, Long quantity, float unitPrice) {
        OrderId = orderId;
        ProductId = productId;
        Quantity = quantity;
        UnitPrice = unitPrice;
    }

    public Long getItemId() {
        return ItemId;
    }

    public void setItemId(Long itemId) {
        ItemId = itemId;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public Long getProductId() {
        return ProductId;
    }

    public void setProductId(Long productId) {
        ProductId = productId;
    }

    public Long getQuantity() {
        return Quantity;
    }

    public void setQuantity(Long quantity) {
        Quantity = quantity;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        UnitPrice = unitPrice;
    }
}
