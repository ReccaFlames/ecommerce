package com.recca.ecommerce.product;

import java.util.List;
import java.util.UUID;

import javax.annotation.security.RolesAllowed;

import com.recca.ecommerce.product.dto.ProductDto;
import com.recca.ecommerce.product.service.ProductService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RolesAllowed("member")
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<ProductDto> getProducts() {
        return productService.findAllProducts();
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable UUID productId) {
        return productService.findProduct(productId);
    }

    @PostMapping
    public ProductDto addNewProduct(@RequestBody ProductDto product) {
        return productService.adddNewProduct(product);
    }

    @PatchMapping
    public ProductDto updateProduct(@RequestBody ProductDto product) {
        return productService.updateProduct(product);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID productId) {
        boolean result = productService.removeProduct(productId);
        if (result) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
