package com.scaler.amit.project_ecomservice.repositories;

import com.scaler.amit.project_ecomservice.models.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
