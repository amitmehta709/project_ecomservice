package com.scaler.amit.project_ecomservice.repositories;

import com.scaler.amit.project_ecomservice.models.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
