package com.example.product.ProductApp.DTO;


import com.example.product.ProductApp.Entity.Category;

public record ProductDto(Long id,String name, String description, Double price, Long categoryId) {
}
