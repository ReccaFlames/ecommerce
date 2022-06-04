package com.recca.ecommerce.product.writer;

import java.util.UUID;

import com.recca.ecommerce.product.dto.ProductDto;
import com.recca.ecommerce.product.entity.ProductEntity;
import com.recca.ecommerce.product.mapper.ProductMapper;
import com.recca.ecommerce.product.repository.ProductRepository;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class ProductWriter {
    
    private ProductRepository repository;

    public ProductDto addProduct(final ProductDto productDto) {
        final var product = ProductMapper.mapDtoToEntity(productDto);
        final var entity = repository.save(product);
        return ProductMapper.mapEntityToDto(entity);
    }

    public ProductDto updateProduct(final ProductDto productDto) {
        final ProductEntity entity = repository.findById(productDto.getProductId())
            .orElseThrow(RuntimeException::new);
        ProductMapper.updatEntity(entity, productDto);
        final var savedEntity = repository.save(entity);
        return ProductMapper.mapEntityToDto(savedEntity);
    }

    public boolean removeProduct(final UUID productId) {
        try {
            repository.deleteById(productId);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
