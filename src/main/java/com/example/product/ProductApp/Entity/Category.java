package com.example.product.ProductApp.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
//@NamedEntityGraph(name = "Category.withProducts",
//        attributeNodes = @NamedAttributeNode("products"))
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //private List<Products> products; //was getting null pointer so intoduced an empty list
    private List<Products> products = new ArrayList<>();
}
