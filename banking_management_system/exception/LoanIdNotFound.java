package com.jsp.banking_management_system.exception;

public class LoanIdNotFound extends RuntimeException{
	
	private String message="Loan not present in DB";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
