package com.recca.ecommerce.product.mapper;

import com.recca.ecommerce.product.dto.ProductDto;
import com.recca.ecommerce.product.entity.ProductEntity;

public class ProductMapper {

    private ProductMapper() {
        // private constructor to hide public imlicite one
    }

    public static ProductDto mapEntityToDto(final ProductEntity entity) {
        return ProductDto.builder()
            .productId(entity.getId())
            .name(entity.getName())
            .shortDescription(entity.getShortDescription())
            .imageUrl(entity.getImageUrl())
            .createdAt(entity.getCreatedAt())
            .createdBy(entity.getCreatedBy())
            .modifiedAt(entity.getModifiedAt())
            .modifiedBy(entity.getModifiedBy())
            .build();
    }

    public static ProductEntity mapDtoToEntity(final ProductDto dto) {
        return ProductEntity.builder()
            .id(dto.getProductId())
            .name(dto.getName())
            .shortDescription(dto.getShortDescription())
            .imageUrl(dto.getImageUrl())
            .createdAt(dto.getCreatedAt())
            .createdBy(dto.getCreatedBy())
            .modifiedAt(dto.getModifiedAt())
            .modifiedBy(dto.getModifiedBy())
            .build();
    }

    public static void updatEntity(final ProductEntity entity, final ProductDto dto) {
        entity.setName(dto.getName());
        entity.setShortDescription(dto.getShortDescription());
        entity.setImageUrl(dto.getImageUrl());
        entity.setModifiedBy(dto.getModifiedBy());
    }
}
