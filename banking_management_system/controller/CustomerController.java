package com.jsp.banking_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.banking_management_system.dto.Account;
import com.jsp.banking_management_system.dto.Card;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.dto.Loan;
import com.jsp.banking_management_system.service.CustomerService;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;
	@PostMapping("/saveCustomer")
	public ResponseStructure<Customer> saveCustomer(@RequestBody Customer customer) {
		return customerService.saveCustomer(customer);
	}
	@GetMapping("/fetchCustomerById")
	public ResponseStructure<Customer> fetchCustomerById(@RequestParam int customerId) {
		return customerService.fetchCustomerById(customerId);
	}
	@PutMapping("/updateCustomer")
	public ResponseStructure<Customer> updateCustomer(@RequestParam int oldId,@RequestBody Customer newCustomer) {
		return customerService.updateCustomer(oldId, newCustomer);
	}
	@DeleteMapping("/deleteCustomerById")
	public ResponseStructure<Customer> deleteCustomerById(@RequestParam int customerId) {
		return customerService.deleteCustomerById(customerId);
	}
	@GetMapping("/fetchAllCustomers")
	public ResponseStructureList<Customer> fetchAllCustomers() {
		return customerService.fetchAllCustomers();
	}
	
	@PutMapping("/addExistingLoansToExistingCustomer")
	public ResponseStructure<Customer> addExistingLoansToExistingCustomer(@RequestParam int loanId,@RequestParam int customerId) {
		return customerService.addExistingLoansToExistingCustomer(loanId, customerId);
	}
	
	@PutMapping("/addNewLoanToExistingCustomer")
	public ResponseStructure<Customer> addNewLoanToExistingCustomer(@RequestParam int customerId,@RequestBody Loan newLoan) {
		return customerService.addNewLoanToExistingCustomer(customerId, newLoan);
	}
	
	@PutMapping("/addExistingCardsToExistingCustomer")
	public ResponseStructure<Customer> addExistingCardsToExistingCustomer(@RequestParam int customerId,@RequestParam int cardId) {
		return customerService.addExistingCardsToExistingCustomer(customerId, cardId);
	}
	
	@PutMapping("/addNewCardsToExistingCustomer")
	public ResponseStructure<Customer> addNewCardsToExistingCustomer(@RequestParam int customerId,@RequestBody Card newCard) {
		return customerService.addNewCardsToExistingCustomer(customerId, newCard);
	}
	
	@PutMapping("/addExistingAccountsToExistingCustomer")
	public ResponseStructure<Customer> addExistingAccountsToExistingCustomer(@RequestParam int customerId,@RequestParam int accountId) {
		return customerService.addExistingAccountsToExistingCustomer(customerId, accountId);
	}
	
	@PutMapping("/addNewAccountToExistingCustomer")
	public ResponseStructure<Customer> addNewAccountToExistingCustomer(@RequestParam int customerId,@RequestBody Account newAccount) {
		return customerService.addNewAccountToExistingCustomer(customerId, newAccount);
	}



}
