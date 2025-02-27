package com.scaler.amit.project_ecomservice.repositories;

import com.scaler.amit.project_ecomservice.models.cart.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
