package com.example.product.ProductApp.DTO;

import com.example.product.ProductApp.Entity.Products;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDTO {

    private Long id;
    private String name;
    private List<ProductDto> products;
}
