package com.example.product_entity;

import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.product_entity.model.Product;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
//		Product product=null;
//		Optional.of(product).map(p->{System.out.println("Inside map"); return p;}).orElseThrow(()-> new RuntimeException());
		
	}
	

}
