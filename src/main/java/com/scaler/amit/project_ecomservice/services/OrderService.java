package com.scaler.amit.project_ecomservice.services;

import com.scaler.amit.project_ecomservice.repositories.OrderItemRepository;
import com.scaler.amit.project_ecomservice.repositories.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }
}
