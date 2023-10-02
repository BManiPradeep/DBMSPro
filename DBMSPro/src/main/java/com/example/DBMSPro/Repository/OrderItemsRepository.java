package com.example.DBMSPro.Repository;

import com.example.DBMSPro.Models.OrderItem;
import com.example.DBMSPro.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemsRepository extends JpaRepository<OrderItem, Long> {
}
