package com.example.product.ProductApp.Mapper;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Entity.Category;

public class CategoryMapper {

    public static Category dtoToEntity(CategoryDTO dto){
        Category entity = new Category();
        entity.setName(dto.getName());
        //entity.setProducts(dto.getProducts());
        return entity;
    }

    public static CategoryDTO entityToDto(Category entity) {

        if(entity==null){
            return null;
        }

        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setProducts(entity.getProducts().stream().map(ProductMapper::toDto).toList());
        return dto;

    }
}
