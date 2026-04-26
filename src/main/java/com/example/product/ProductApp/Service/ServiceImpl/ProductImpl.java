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

import java.util.List;

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

    @Override
    public List<ProductDto> getAllProducts() {
        return repo.findAll().stream().map(ProductMapper::toDto).toList();
    }

    @Override
    public ProductDto getbyId(Long id) {
        Products products = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Givrn product with id " + id + " does not exist"));
        ProductDto dto = ProductMapper.toDto(products);
        return dto;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto dto) {
        //check for it in db for given id
        Products products = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Givrn product with id " + id + " does not exist"));
        //check for category too in category db
        Category category = repo2.findById(dto.categoryId())
                .orElseThrow(() -> new RuntimeException("Given category does not exist"));
        //now update the details to fetched result from dto
        products.setName(dto.name());
        products.setDesc(dto.desc());
        products.setPrice(dto.price());
        products.setCategory(category);
        //save the entity to db
        repo.save(products);
        return ProductMapper.toDto(products);
    }

    @Override
    public String deletebyId(Long id) {
        repo.deleteById(id);
        return "Row deleted for given id "+id;
    }


}
