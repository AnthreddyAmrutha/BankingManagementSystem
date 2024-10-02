package com.jsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.banking_management_system.dao.AccountDao;
import com.jsp.banking_management_system.dto.Account;
import com.jsp.banking_management_system.dto.Address;
import com.jsp.banking_management_system.exception.AccountIdNotFound;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@Service
public class AccountService {

	@Autowired
	AccountDao accountDao;

	@Autowired
	ResponseStructure<Account> responseStructure;

	@Autowired
	ResponseStructureList<Account> responseStructureList;

	public ResponseStructure<Account> saveAccount(Account account) {
		responseStructure.setMessage("Successfully Account saved into DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(accountDao.saveAccount(account));
		return responseStructure;
	}

	public ResponseStructure<Account> fetchAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("Successfully Account fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(accountDao.fetchAccountById(accountId));
			return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructure<Account> updateAccount(int oldId, Account newAccount) {
		Account account = accountDao.fetchAccountById(oldId);
		if (account != null) {
			responseStructure.setMessage("Successfully account updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(accountDao.updateAccount(oldId, newAccount));
			return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructure<Account> deleteAccountById(int accountId) {
		Account account = accountDao.fetchAccountById(accountId);
		if (account != null) {
			responseStructure.setMessage("Successfully Account deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(accountDao.deleteAccountById(accountId));
			return responseStructure;
		} else {
			throw new AccountIdNotFound();
		}
	}

	public ResponseStructureList<Account> fetchAllAccounts() {
		responseStructureList.setMessage("Successfully fetched all Accounts from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(accountDao.fetchAllAccounts());
		return responseStructureList;
	}
}
