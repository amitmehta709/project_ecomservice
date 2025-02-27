package com.scaler.amit.project_ecomservice.services;

import com.scaler.amit.project_ecomservice.dtos.CreateProductDto;
import com.scaler.amit.project_ecomservice.dtos.ProductDto;
import com.scaler.amit.project_ecomservice.models.product.Category;
import com.scaler.amit.project_ecomservice.models.product.Product;
import com.scaler.amit.project_ecomservice.repositories.CategoryRepository;
import com.scaler.amit.project_ecomservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public Product createProduct(CreateProductDto createProductDto) {

        Optional<Category> optionalCategory = categoryRepository.findByName(createProductDto.getCategory());
        Category addCategory;
        if (optionalCategory.isPresent()) {
            addCategory = optionalCategory.get();
        }
        else {
            addCategory = new Category();
            addCategory.setName(createProductDto.getCategory());
            categoryRepository.save(addCategory);
        }
        Product product = new Product();
        product.setCategory(addCategory);
        product.setTitle(createProductDto.getTitle());
        product.setDescription(createProductDto.getDescription());
        product.setPrice(createProductDto.getPrice());
        product.setStockQuantity(createProductDto.getStockQuantity());
        return productRepository.save(product);
    }
}
