package com.recca.ecommerce.product.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    
    private UUID productId;
    private String name;
    private String shortDescription;
    private String imageUrl;
    private Instant createdAt;
    private UUID createdBy;
    private Instant modifiedAt;
    private UUID modifiedBy;
}