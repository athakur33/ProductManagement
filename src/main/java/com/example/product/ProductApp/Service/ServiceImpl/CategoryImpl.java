package com.example.product.ProductApp.Service.ServiceImpl;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Entity.Category;
import com.example.product.ProductApp.Mapper.CategoryMapper;
import com.example.product.ProductApp.Repository.CategoryRepo;
import com.example.product.ProductApp.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CategoryImpl implements CategoryService {

    private CategoryRepo repo;
   // private CategoryMapper mapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = CategoryMapper.dtoToEntity(dto);
        Category save = repo.save(category);
        CategoryDTO categoryDTO = CategoryMapper.entityToDto(save);
        return categoryDTO;
    }
}
