package com.example.product_entity.exception;

public class ProductNotFoundException extends RuntimeException {
	
	private String message;

	public ProductNotFoundException(String message) {
		this.message = message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	

}
