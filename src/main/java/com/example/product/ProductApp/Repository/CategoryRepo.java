package com.example.product.ProductApp.Repository;

import com.example.product.ProductApp.DTO.CategoryDTO;
import com.example.product.ProductApp.Entity.Category;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    Optional<Category> findByName(String name);

   @EntityGraph(attributePaths = "products")
    //select c1_0.id,c1_0.name,p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.price from category c1_0 left join products p1_0 on c1_0.id=p1_0.category_id
    List<Category> findAll();


   //manual join query for n+1 issue
    @Query("SELECT c FROM Category c LEFT JOIN FETCH c.products")
    List<Category> fetchCategoriesWithProducts();

   /*Hibernate: select c1_0.id,c1_0.name from category c1_0
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.price from products p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.price from products p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.price from products p1_0 where p1_0.category_id=?
Hibernate: select p1_0.category_id,p1_0.id,p1_0.description,p1_0.name,p1_0.price from products p1_0 where p1_0.category_id=?*/
}
