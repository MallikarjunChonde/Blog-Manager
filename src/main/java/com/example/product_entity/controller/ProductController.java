package com.example.product_entity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.product_entity.model.Product;
import com.example.product_entity.productdto.ProductDTO;
import com.example.product_entity.service.ProductService;
import com.example.product_entity.utility.ErrorStructerUser;
import com.example.product_entity.utility.ResponseStructure;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
public class ProductController {
@Autowired
	private ProductService productService;
	
	
//	public ProductController(ProductService productService) {
//
//		this.productService = productService;
//	}

//	@PostMapping("/products")                             //rest web services
//	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) {
//		return productService.saveProduct(product);	
//	}

	@PostMapping("/products")
	@Operation(description = "The end poind is used to add new product in database",responses = {
			@ApiResponse(responseCode = "200",description = "Product saved sucssefully"),
			@ApiResponse(responseCode = "400",description = "Invalid input")})
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody ProductDTO productdto){
		return productService.saveProduct(productdto);
	}
	
	@Operation(description = "The end point used to find product by ID",responses = {
			@ApiResponse(responseCode = "200"
			,description = "Product found"),
			@ApiResponse(responseCode = "404",description = "Product not found by give id", 
			content = {
					@Content(schema = @Schema(implementation = ErrorStructerUser.class))
			})
	})
	@GetMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> findByProductId(@PathVariable int productId) {
		
			return productService.findByProductId(productId);
		
	}
	
	@PutMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> updateByActorId(@PathVariable int productId,@RequestBody Product product) {
		return productService.updateByProductId(productId, product);
	}

	@DeleteMapping("/products/{productId}")
	public ResponseEntity<ResponseStructure<Product>> deleteByactorId(@PathVariable int productId) {
		return productService.deleteByProductId(productId);
	}
	
	@GetMapping("/products")
	public ResponseEntity<ResponseStructure<List<Product>>> findAllActor() {
		
		return productService.findAllProduct();
		
	}
	
}
