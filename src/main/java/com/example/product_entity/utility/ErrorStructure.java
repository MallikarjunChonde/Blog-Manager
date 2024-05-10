package com.example.product_entity.utility;

public class ErrorStructure<T> {
	private int statusCode;
	private String errorMessage;
	private T errorDate;
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public T getErrorDate() {
		return errorDate;
	}
	public void setErrorDate(T errorDate) {
		this.errorDate = errorDate;
	}
	

}
