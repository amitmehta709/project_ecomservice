package com.scaler.amit.project_ecomservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCartItemtDto {
    private Long productId;
    private int quantity;
}
