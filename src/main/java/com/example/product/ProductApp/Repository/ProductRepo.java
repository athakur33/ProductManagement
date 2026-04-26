package com.example.product.ProductApp.Repository;

import com.example.product.ProductApp.Entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Products,Long> {
}
