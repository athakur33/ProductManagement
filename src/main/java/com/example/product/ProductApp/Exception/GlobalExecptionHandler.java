package com.example.product.ProductApp.Exception;

import com.example.product.ProductApp.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExecptionHandler {

    @ExceptionHandler(CategoryAlreadyExists.class)
    public ResponseEntity<?> handleCategoryAlreadyExists(CategoryAlreadyExists ex){
       return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<?> handleCategoryNotFound(CategoryNotFoundException ex, WebRequest web){

        ExceptionResponseDTO dto = new ExceptionResponseDTO(
                web.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(dto,HttpStatus.NOT_FOUND);

       // return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
