package com.example.product_entity.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.product_entity.model.Product;
import com.example.product_entity.productdto.ProductDTO;
import com.example.product_entity.utility.ResponseStructure;

public interface ProductService {

//	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product);

	public ResponseEntity<ResponseStructure<Product>> findByProductId(int productId);

	public ResponseEntity<ResponseStructure<Product>> updateByProductId(int productId, Product product);

	public ResponseEntity<ResponseStructure<Product>> deleteByProductId(int productId);

	public ResponseEntity<ResponseStructure<List<Product>>> findAllProduct();

	public ResponseEntity<ResponseStructure<Product>> saveProduct(ProductDTO productdto);

}
