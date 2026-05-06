package com.example.product.ProductApp.Controller;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Exception.CategoryAlreadyExists;
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

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategorywithProduct(){
        List<CategoryDTO> allCategory = service.findAllCategorywithProduct();
        return new ResponseEntity<>(allCategory,HttpStatus.FOUND);
    }


    //create Categories
    @PostMapping
    //http://localhost:8080/api/v1/categories
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dto){
        CategoryDTO category = service.createCategory(dto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @PostMapping("/v2")
    //http://localhost:8080/api/v1/categories/v2
    //http://localhost:8080/api/v1/categories
    public ResponseEntity<?> createCategoryV1(@RequestBody CategoryDTO dto){
        //CategoryDTO category = service.createCategory(dto);
        try{
            CategoryDTO category = service.createCategory(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        }
        catch(CategoryAlreadyExists ex){
          return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
       // return new ResponseEntity<>(category, HttpStatus.CREATED);
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
