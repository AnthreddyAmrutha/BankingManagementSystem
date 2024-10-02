package com.jsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.banking_management_system.dao.CustomerDao;
import com.jsp.banking_management_system.dao.EmployeeDao;
import com.jsp.banking_management_system.dto.Account;
import com.jsp.banking_management_system.dto.Card;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.dto.Loan;
import com.jsp.banking_management_system.exception.CustomerIdNotFound;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	ResponseStructure<Customer> responseStructure;

	@Autowired
	ResponseStructureList<Customer> responseStructureList;

	public ResponseStructure<Customer> saveCustomer(Customer customer) {
		responseStructure.setMessage("Successfully customer saved into DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(customerDao.saveCustomer(customer));
		return responseStructure;
	}

	public ResponseStructure<Customer> fetchCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("Successfully customer fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(customerDao.fetchCustomerById(customerId));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> updateCustomer(int oldId, Customer newCustomer) {
		Customer customer = customerDao.fetchCustomerById(oldId);
		if (customer != null) {
			responseStructure.setMessage("Successfully customer updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.updateCustomer(oldId, newCustomer));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructure<Customer> deleteCustomerById(int customerId) {
		Customer customer = customerDao.fetchCustomerById(customerId);
		if (customer != null) {
			responseStructure.setMessage("Successfully customer deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(customerDao.deleteCustomerById(customerId));
			return responseStructure;
		} else {
			throw new CustomerIdNotFound();
		}
	}

	public ResponseStructureList<Customer> fetchAllCustomers() {
		responseStructureList.setMessage("Successfully fetched all customers from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(customerDao.fetchAllCustomers());
		return responseStructureList;
	}

	public ResponseStructure<Customer> addExistingLoansToExistingCustomer(int loanId, int customerId) {
		responseStructure.setMessage("Successfully added Existing Loans To Existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingLoansToExistingCustomer(loanId, customerId));
		return responseStructure;
	}

	public ResponseStructure<Customer> addNewLoanToExistingCustomer(int customerId, Loan newLoan) {
		responseStructure.setMessage("Successfully added new Loans To Existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewLoanToExistingCustomer(customerId, newLoan));
		return responseStructure;
	}

	public ResponseStructure<Customer> addExistingCardsToExistingCustomer(int customerId, int cardId) {
		responseStructure.setMessage("Successfully added Existing Cards To Existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingCardsToExistingCustomer(customerId, cardId));
		return responseStructure;
	}

	public ResponseStructure<Customer> addNewCardsToExistingCustomer(int customerId, Card newCard) {
		responseStructure.setMessage("Successfully added New Cards To Existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewCardsToExistingCustomer(customerId, newCard));
		return responseStructure;
	}

	public ResponseStructure<Customer> addExistingAccountsToExistingCustomer(int customerId, int accountId) {
		responseStructure.setMessage("Successfully added Existing Accounts To Existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addExistingAccountsToExistingCustomer(customerId, accountId));
		return responseStructure;
	}

	public ResponseStructure<Customer> addNewAccountToExistingCustomer(int customerId, Account newAccount) {
		responseStructure.setMessage("Successfully added new Cards To Existing Customer in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(customerDao.addNewAccountToExistingCustomer(customerId, newAccount));
		return responseStructure;
	}

}
