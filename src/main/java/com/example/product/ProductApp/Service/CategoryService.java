package com.example.product.ProductApp.Service;

import com.example.product.ProductApp.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

   CategoryDTO createCategory(CategoryDTO dto);
   List<CategoryDTO> findAllCategory();
   CategoryDTO getById(Long id);
   String deleteCategory(Long id);

}
