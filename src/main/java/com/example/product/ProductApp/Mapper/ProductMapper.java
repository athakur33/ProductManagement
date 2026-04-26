package com.example.product.ProductApp.Mapper;

import com.example.product.ProductApp.DTO.ProductDto;
import com.example.product.ProductApp.Entity.Category;
import com.example.product.ProductApp.Entity.Products;

public class ProductMapper {

    public static ProductDto toDto(Products products){

        return new ProductDto(products.getId(), products.getName(),
                products.getDescription(), products.getPrice(),products.getCategory().getId() );
    }

    public static Products toEntity(ProductDto dto , Category category){

        return new Products(dto.id(), dto.name(), dto.description(),dto.price(),category);
    }
}
