package com.example.product.ProductApp.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ExceptionResponseDTO {

    private String apiPath;
    private HttpStatus status;
    private String errorMsg;
    private LocalDateTime errorTime;
}
