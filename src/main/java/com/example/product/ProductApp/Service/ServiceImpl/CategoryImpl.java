package com.example.product.ProductApp.Service.ServiceImpl;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Entity.Category;
import com.example.product.ProductApp.Mapper.CategoryMapper;
import com.example.product.ProductApp.Repository.CategoryRepo;
import com.example.product.ProductApp.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<CategoryDTO> findAllCategory() {
        return repo.findAll().stream().map(CategoryMapper :: entityToDto).toList();
    }

    @Override
    public CategoryDTO getById(Long id) {
        Category category = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No category found for given id " + id));
       return CategoryMapper.entityToDto(category);
    }

    @Override
    public String deleteCategory(Long id) {
        repo.deleteById(id);
        return "The category entry deleted for "+id;
    }
}
