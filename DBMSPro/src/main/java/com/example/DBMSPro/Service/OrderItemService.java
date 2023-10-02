package com.example.DBMSPro.Service;

import com.example.DBMSPro.Repository.OrderItemsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService {

    private final OrderItemsRepository orderItemsRepository;

    @Autowired
    public OrderItemService(OrderItemsRepository orderItemsRepository) {
        this.orderItemsRepository = orderItemsRepository;
    }
}
