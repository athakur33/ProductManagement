package com.example.product.ProductApp.Service;

import com.example.product.ProductApp.DTO.CategoryDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryService {
    CategoryDTO createCategory(CategoryDTO dto);
   // @EntityGraph("Category.withProducts")
   // @Query("SELECT c FROM Category c")
   List<CategoryDTO> findAllCategory();
   CategoryDTO getById(Long id);
   String deleteCategory(Long id);

    List<CategoryDTO> findAllCategorywithProduct();



}
