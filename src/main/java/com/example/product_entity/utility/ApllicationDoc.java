package com.example.product_entity.utility;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;


@Configuration
@OpenAPIDefinition
public class ApllicationDoc {
	
	io.swagger.v3.oas.models.info.Contact contact() {
		return new io.swagger.v3.oas.models.info.Contact().name("Mallikarjun").url("https://github.com/MallikarjunChonde").email("mallikarjunchonde89@gmail.com");
		
	}
	
     @Bean
	Info info() {
		return new Info().title("Product Management System")
				.description("Restfull API with basic CURD operation")
				.version("v1");
	}

	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
}
