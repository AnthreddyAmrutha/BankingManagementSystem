package com.jsp.banking_management_system.exception;

public class BranchIdNotFound extends RuntimeException{
	
	private String message="Branch not present in DB";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
