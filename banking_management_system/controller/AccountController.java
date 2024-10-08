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
import com.jsp.banking_management_system.service.AccountService;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@RestController
public class AccountController {

	@Autowired
	AccountService accountService;
	@PostMapping("/saveAccount")
	public ResponseStructure<Account> saveAccount(@RequestBody Account account) {
		return accountService.saveAccount(account);
	}
	@GetMapping("/fetchAccountById")
	public ResponseStructure<Account> fetchAccountById(@RequestParam int accountId) {
		return accountService.fetchAccountById(accountId);
	}
	@PutMapping("/updateAccount")
	public ResponseStructure<Account> updateAccount(@RequestParam int oldId,@RequestBody Account newAccount) {
		return accountService.updateAccount(oldId, newAccount);
	}
	@DeleteMapping("/deleteAccountById")
	public ResponseStructure<Account> deleteAccountById(@RequestParam int accountId) {
		return accountService.deleteAccountById(accountId);
	}
	@GetMapping("/fetchAllAccounts")
	public ResponseStructureList<Account> fetchAllAccounts() {
		return accountService.fetchAllAccounts();
				
	}
}
