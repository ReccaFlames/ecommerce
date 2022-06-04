package com.recca.ecommerce.product.reader;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import com.recca.ecommerce.product.dto.ProductDto;
import com.recca.ecommerce.product.mapper.ProductMapper;
import com.recca.ecommerce.product.repository.ProductRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductReader {
    
    private ProductRepository repository;

    public List<ProductDto> findAllProducts() {
        return repository.findAll().stream()
            .map(ProductMapper::mapEntityToDto)
            .collect(Collectors.toList());
    }

    public Optional<ProductDto> findProductById(final UUID productId) {
        return repository.findById(productId)
            .map(ProductMapper::mapEntityToDto);
    }
}
