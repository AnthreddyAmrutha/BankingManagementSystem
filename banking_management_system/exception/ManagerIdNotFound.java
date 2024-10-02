package com.jsp.banking_management_system.exception;

public class ManagerIdNotFound extends RuntimeException {

	private String message="Manager not present in DB";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
