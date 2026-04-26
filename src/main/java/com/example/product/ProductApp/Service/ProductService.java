package com.example.product.ProductApp.Service;

import com.example.product.ProductApp.DTO.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto createProduct(ProductDto dto);
    List<ProductDto> getAllProducts();
}
