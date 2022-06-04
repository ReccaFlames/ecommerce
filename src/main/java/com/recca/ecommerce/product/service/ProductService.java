package com.recca.ecommerce.product.service;

import java.util.List;
import java.util.UUID;

import com.recca.ecommerce.product.dto.ProductDto;
import com.recca.ecommerce.product.reader.ProductReader;
import com.recca.ecommerce.product.writer.ProductWriter;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductService {
    
    private ProductReader reader;
    private ProductWriter writer;

    public List<ProductDto> findAllProducts() {
        return reader.findAllProducts();
    }

    public ProductDto findProduct(final UUID productId) {
        return reader.findProductById(productId).orElse(null);
    }

    public ProductDto adddNewProduct(final ProductDto productDto) {
        return writer.addProduct(productDto);
    }

    public ProductDto updateProduct(final ProductDto productDto) {
        return writer.updateProduct(productDto);
    }

    public boolean removeProduct(final UUID productId) {
        return writer.removeProduct(productId);
    }
}
