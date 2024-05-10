package com.example.product_entity.utility;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.product_entity.exception.ProductNotFoundByIdException;

public class ApplicationHandler {
	@ExceptionHandler
	public ResponseEntity<ErrorStructure<String>> productNotFoundByIdException(ProductNotFoundByIdException ex){
		
		ErrorStructure<String> errorStructre=new ErrorStructure<>();
		errorStructre.setStatusCode(HttpStatus.NOT_FOUND.value());
	    errorStructre.setErrorMessage(ex.getMessage());
	    errorStructre.setErrorDate("Product object with the give id does't exist!!");
	    
	    return new ResponseEntity<ErrorStructure<String>>(errorStructre,HttpStatus.NOT_FOUND);
	}

}
