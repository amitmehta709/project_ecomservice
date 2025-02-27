package com.scaler.amit.project_ecomservice.repositories;

import com.scaler.amit.project_ecomservice.models.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
