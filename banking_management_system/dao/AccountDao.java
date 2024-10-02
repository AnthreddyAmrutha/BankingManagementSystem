package com.jsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.banking_management_system.dto.Account;
import com.jsp.banking_management_system.repo.AccountRepo;

@Repository
public class AccountDao {

	@Autowired
	AccountRepo accountRepo;
	
	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}
	
	public Account fetchAccountById(int accountId) {
		Optional<Account> account=accountRepo.findById(accountId);
		if(account.isPresent()) {
			return account.get();
		}
		else {
			return null;
		}
	}
	
	public Account updateAccount(int oldId,Account newAccount) {
		newAccount.setAccountId(oldId);
		return saveAccount(newAccount);
	}
	
	public Account deleteAccountById(int accountId) {
		Account account=fetchAccountById(accountId);
		accountRepo.delete(account);
		return account;
	}
	
	public List<Account> fetchAllAccounts() {
		return accountRepo.findAll();
	}
}
