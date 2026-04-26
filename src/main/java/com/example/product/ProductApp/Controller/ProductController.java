package com.example.product.ProductApp.Controller;

import com.example.product.ProductApp.DTO.ProductDto;
import com.example.product.ProductApp.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {

    private ProductService service;
    //getProduct
    //createProduct
    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
        ProductDto product = service.createProduct(dto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }
    //updateProduct
    //getProductbyId
    //deleteProduct



}
