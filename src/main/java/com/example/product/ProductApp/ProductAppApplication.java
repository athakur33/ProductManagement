package com.example.product.ProductApp;

import com.example.product.ProductApp.Component.MyComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProductAppApplication {

    @Bean
    public MyComponent component(){
        return new MyComponent();
    }

	public static void main(String[] args) {


        SpringApplication.run(ProductAppApplication.class, args);

       // ApplicationContext context = SpringApplication.run(ProductAppApplication.class, args);
       // MyComponent bean = context.getBean(MyComponent.class);
       // bean.CompMethod();
    }

}
