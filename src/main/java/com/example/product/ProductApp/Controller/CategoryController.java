package com.example.product.ProductApp.Controller;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService service;
    //get all categories
    //create Categories
    @PostMapping
    //http://localhost:8080/api/v1/categories
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
        CategoryDTO category = service.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //get Category by id
}
