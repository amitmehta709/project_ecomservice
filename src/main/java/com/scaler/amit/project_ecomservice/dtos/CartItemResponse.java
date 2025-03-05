package com.scaler.amit.project_ecomservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemResponse{
    private Long id;
    private Long productId;
    private String productName;
    private int quantity;
    private double price;
}
