package com.jsp.banking_management_system.exception;

public class OwnerIdNotFound extends RuntimeException{
	
	private String message="Owner not present in DB";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
