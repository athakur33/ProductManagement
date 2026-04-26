package com.example.product.ProductApp.Component;

import org.springframework.stereotype.Component;

//@Component
public class MyComponent {

    public MyComponent(){
        System.out.println("Inside My Component");
    }

    public void CompMethod(){
        System.out.println("I am a method of my Component");
    }
}
