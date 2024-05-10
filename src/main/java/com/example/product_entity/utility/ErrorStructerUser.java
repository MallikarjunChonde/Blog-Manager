package com.example.product_entity.utility;

public class ErrorStructerUser {
	private int statusCode;
	private String errorMessage;
	private Object rootCouse;
	public int getStatusCode() {
		return statusCode;
	}
	public ErrorStructerUser setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructerUser setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;

	}
	public Object getRootCouse() {
		return rootCouse;
	}
	public ErrorStructerUser setRootCouse(Object rootCouse) {
		this.rootCouse = rootCouse;
		return this;

	}
	
	

}
