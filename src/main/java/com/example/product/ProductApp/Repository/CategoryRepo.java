package com.example.product.ProductApp.Repository;

import com.example.product.ProductApp.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category,Long> {
}
