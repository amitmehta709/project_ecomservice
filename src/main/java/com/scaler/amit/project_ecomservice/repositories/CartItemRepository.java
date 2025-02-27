package com.scaler.amit.project_ecomservice.repositories;

import com.scaler.amit.project_ecomservice.models.cart.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}
