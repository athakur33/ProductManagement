package com.example.product.ProductApp.Repository;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);
}
