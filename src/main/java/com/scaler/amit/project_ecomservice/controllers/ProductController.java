package com.scaler.amit.project_ecomservice.controllers;

import com.scaler.amit.project_ecomservice.dtos.CreateProductDto;
import com.scaler.amit.project_ecomservice.dtos.ProductDto;
import com.scaler.amit.project_ecomservice.exceptions.InvalidDataException;
import com.scaler.amit.project_ecomservice.exceptions.NotFoundException;
import com.scaler.amit.project_ecomservice.models.product.Product;
import com.scaler.amit.project_ecomservice.services.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/productsapi")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDto> crateProduct(@RequestBody CreateProductDto createProductDto) throws InvalidDataException {
        Product product = productService.createProduct(createProductDto);
        return new ResponseEntity<>(ProductDto.fromProduct(product), HttpStatus.CREATED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable long id) throws NotFoundException {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(ProductDto.fromProduct(product), HttpStatus.OK);
    }

    @GetMapping("/product/all")
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : products) {
            productDtoList.add(ProductDto.fromProduct(product));
        }
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }

    @PatchMapping("/product/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable long id,
                                                    @RequestBody Map<String, Object> updates) throws NotFoundException {
        Product product = productService.updateProduct(id, updates);
        return new ResponseEntity<>(ProductDto.fromProduct(product), HttpStatus.OK);
    }
}
