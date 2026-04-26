package com.example.product.ProductApp.Controller;

import com.example.product.ProductApp.DTO.ProductDto;
import com.example.product.ProductApp.Service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class ProductController {

    private ProductService service;
    //getProduct
    //createProduct
    @PostMapping
    //http://localhost:8080/api/v1/products
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto dto){
        ProductDto product = service.createProduct(dto);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //getAll products
    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        List<ProductDto> allProducts = service.getAllProducts();
        return new ResponseEntity<>(allProducts,HttpStatus.FOUND);
    }

    //updateProduct
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateRecords(@PathVariable Long id, @RequestBody ProductDto dto){
        ProductDto productDto = service.updateProduct(id, dto);
        return new ResponseEntity<>(productDto,HttpStatus.CREATED);
    }


    //getProductbyId
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> getbyId(@PathVariable Long id){
        ProductDto productDto = service.getbyId(id);
        return new ResponseEntity<>(productDto,HttpStatus.FOUND);
    }
    //deleteProduct
    @DeleteMapping("{id}")
    public String deleteRecord(@PathVariable Long id){
        service.deletebyId(id);
        return "Data has been deleted from DB";

    }


}
