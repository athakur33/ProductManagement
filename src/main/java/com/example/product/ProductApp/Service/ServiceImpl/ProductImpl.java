package com.example.product.ProductApp.Service.ServiceImpl;

import com.example.product.ProductApp.DTO.ProductDto;
import com.example.product.ProductApp.Entity.Category;
import com.example.product.ProductApp.Entity.Products;
import com.example.product.ProductApp.Mapper.ProductMapper;
import com.example.product.ProductApp.Repository.CategoryRepo;
import com.example.product.ProductApp.Repository.ProductRepo;
import com.example.product.ProductApp.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProductImpl implements ProductService {

    private ProductRepo repo;
    private CategoryRepo repo2;


    @Override
    public ProductDto createProduct(ProductDto dto) {
       // ProductMapper.toEntity(dto);
        //first check if the given category is present or not so use category repo for it
        Category category = repo2.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("No such category found"));
        //dto to entity
        Products entity = ProductMapper.toEntity(dto, category);
        //save to db
        Products save = repo.save(entity);
        //entity to dto
        ProductDto dto1 = ProductMapper.toDto(save);
        return dto1;
    }
}
