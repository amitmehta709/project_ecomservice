package com.scaler.amit.project_ecomservice.services;

import com.scaler.amit.project_ecomservice.repositories.CartItemRepository;
import com.scaler.amit.project_ecomservice.repositories.CartRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
    }


}
