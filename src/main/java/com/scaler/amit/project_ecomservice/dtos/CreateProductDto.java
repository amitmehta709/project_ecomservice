package com.scaler.amit.project_ecomservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateProductDto {
    private String title;
    private String description;
    private double price;
    private int stockQuantity;
    private double rating;
    private String category;
}
