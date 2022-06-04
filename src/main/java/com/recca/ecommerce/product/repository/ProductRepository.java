package com.recca.ecommerce.product.repository;

import java.util.UUID;
import com.recca.ecommerce.product.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    
}
