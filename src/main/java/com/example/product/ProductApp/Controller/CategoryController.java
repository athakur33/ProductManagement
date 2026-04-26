package com.example.product.ProductApp.Controller;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor
public class CategoryController {

    private CategoryService service;
    //get all categories
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> allCategory = service.findAllCategory();
        return new ResponseEntity<>(allCategory,HttpStatus.FOUND);
    }


    //create Categories
    @PostMapping
    //http://localhost:8080/api/v1/categories
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
        CategoryDTO category = service.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    //get Category by id
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getbyId(@PathVariable Long id){
        CategoryDTO byId = service.getById(id);
        return new ResponseEntity<>(byId,HttpStatus.FOUND);
    }

    //delete categories
    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable("id") Long category_id){
       return service.deleteCategory(category_id);
    }
}
