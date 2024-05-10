package com.example.product_entity.exception;

public class ProductNotFoundByIdException extends RuntimeException{

	private String message;

	public ProductNotFoundByIdException(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	

}
