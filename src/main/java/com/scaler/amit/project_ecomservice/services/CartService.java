package com.scaler.amit.project_ecomservice.services;

import com.scaler.amit.project_ecomservice.dtos.AddCartItemtDto;
import com.scaler.amit.project_ecomservice.repositories.CartItemRepository;
import com.scaler.amit.project_ecomservice.repositories.CartRepository;
import com.scaler.amit.project_ecomservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private CartRepository cartRepository;
    private CartItemRepository cartItemRepository;
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository,
                       ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public void addItemsToCart(Long userId, AddCartItemtDto addCartItemtDto) {

    }

    public void removeItemsFromCart(Long userId, AddCartItemtDto addCartItemtDto) {

    }

    public void clearCart(Long userId) {

    }

    public void getCartItems(Long userId) {

    }

}
