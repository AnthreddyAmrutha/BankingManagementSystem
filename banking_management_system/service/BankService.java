package com.jsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.banking_management_system.dao.BankDao;
import com.jsp.banking_management_system.dto.Atm;
import com.jsp.banking_management_system.dto.Bank;
import com.jsp.banking_management_system.dto.Branch;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.exception.BankIdNotFound;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@Service
public class BankService {

	@Autowired
	BankDao bankDao;

	@Autowired
	ResponseStructure<Bank> responseStructure;

	@Autowired
	ResponseStructureList<Bank> responseStructureList;

	public ResponseStructure<Bank> saveBank(Bank bank) {
		responseStructure.setMessage("Successfully bank saved into DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(bankDao.saveBank(bank));
		return responseStructure;
	}

	public ResponseStructure<Bank> fetchBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("Successfully bank fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(bankDao.fetchBankById(bankId));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructure<Bank> updateBank(int oldId, Bank newBank) {
		Bank bank = bankDao.fetchBankById(oldId);
		if (bank != null) {
			responseStructure.setMessage("Successfully bank updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.updateBank(oldId, newBank));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructure<Bank> deleteBankById(int bankId) {
		Bank bank = bankDao.fetchBankById(bankId);
		if (bank != null) {
			responseStructure.setMessage("Successfully bank deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(bankDao.deleteBankById(bankId));
			return responseStructure;
		} else {
			throw new BankIdNotFound();
		}
	}

	public ResponseStructureList<Bank> fetchAllBanks() {
		responseStructureList.setMessage("Successfully fetched all Banks from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(bankDao.fetchAllBanks());
		return responseStructureList;
	}

	public ResponseStructure<Bank> addExistingBranchToExistingBank(int branchId, int bankId) {
		responseStructure.setMessage("Successfully added existing branch To Existing Bank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addExistingBranchToExistingBank(branchId, bankId));
		return responseStructure;
	}

	public ResponseStructure<Bank> addNewBranchToExistingBank(int bankId, Branch newBranch) {
		responseStructure.setMessage("Successfully added new Branch To Existing Bank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addNewBranchToExistingBank(bankId, newBranch));
		return responseStructure;
	}

	public ResponseStructure<Bank> addExistingAtmsToExistingBank(int atmId, int bankId) {
		responseStructure.setMessage("Successfully added existing ATM To Existing Bank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addExistingAtmsToExistingBank(atmId, bankId));
		return responseStructure;
	}

	public ResponseStructure<Bank> addNewAtmToExistingBank(int bankId, Atm newAtm) {
		responseStructure.setMessage("Successfully added new ATM To Existing Bank in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(bankDao.addNewAtmToExistingBank(bankId, newAtm));
		return responseStructure;
	}

}
