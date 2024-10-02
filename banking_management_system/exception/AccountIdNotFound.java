package com.jsp.banking_management_system.exception;

public class AccountIdNotFound extends RuntimeException{
	
	private String message="Account not present in DB";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
