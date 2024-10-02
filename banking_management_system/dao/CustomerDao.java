package com.jsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.banking_management_system.dto.Account;
import com.jsp.banking_management_system.dto.Card;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.dto.Loan;
import com.jsp.banking_management_system.repo.CustomerRepo;

@Repository
public class CustomerDao {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	LoanDao loanDao;

	@Autowired
	CardDao cardDao;
	
	@Autowired
	AccountDao accountDao;
	
	public Customer saveCustomer(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer fetchCustomerById(int customerId) {
		Optional<Customer> customer=customerRepo.findById(customerId);
		if(customer.isPresent()) {
			return customer.get();
		}
		else {
			return null;
		}
	}
	
	public Customer updateCustomer(int oldId,Customer newCustomer) {
		newCustomer.setCustomerId(oldId);
		return saveCustomer(newCustomer);
	}
	
	public Customer deleteCustomerById(int customerId) {
		Customer customer=fetchCustomerById(customerId);
		customerRepo.delete(customer);
		return customer;
	}
	
	public List<Customer> fetchAllCustomers() {
		return customerRepo.findAll();
	}
	
	public Customer addExistingLoansToExistingCustomer(int loanId,int customerId) {
		Loan loan=loanDao.fetchLoanById(loanId);
		Customer customer=fetchCustomerById(customerId);
		List<Loan> list= customer.getLoans();
		list.add(loan);
		customer.setLoans(list);
		return saveCustomer(customer);
	}

	public Customer addNewLoanToExistingCustomer(int customerId,Loan newLoan) {
		Customer customer=fetchCustomerById(customerId);
		List<Loan> list= customer.getLoans();
		list.add(newLoan);
		customer.setLoans(list);
		return saveCustomer(customer);
	}

	
	
	public Customer addExistingCardsToExistingCustomer(int customerId,int cardId) {
        Card card=cardDao.fetchCardById(cardId);
		Customer customer=fetchCustomerById(customerId);
		List<Card> list=customer.getCards();
		list.add(card);
		customer.setCards(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewCardsToExistingCustomer(int customerId,Card newCard) {
		Customer customer=fetchCustomerById(customerId);
		List<Card> list=customer.getCards();
		list.add(newCard);
		customer.setCards(list);
		return saveCustomer(customer);
	}
	
	public Customer addExistingAccountsToExistingCustomer(int customerId,int accountId) {
		Account account=accountDao.fetchAccountById(accountId);
		Customer customer=fetchCustomerById(customerId);
		List<Account> list=customer.getAccounts();
		list.add(account);
		customer.setAccounts(list);
		return saveCustomer(customer);
	}
	
	public Customer addNewAccountToExistingCustomer(int customerId,Account newAccount) {
		Customer customer=fetchCustomerById(customerId);
		List<Account> list=customer.getAccounts();
		list.add(newAccount);
		customer.setAccounts(list);
		return saveCustomer(customer);
	}
	
	
	
	
}
