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

import com.jsp.banking_management_system.dto.Atm;
import com.jsp.banking_management_system.dto.Bank;
import com.jsp.banking_management_system.dto.Branch;
import com.jsp.banking_management_system.service.BankService;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@RestController
public class BankController {

	@Autowired
	BankService bankService;

	@PostMapping("/saveBank")
	public ResponseStructure<Bank> saveBank(@RequestBody Bank bank) {
		return bankService.saveBank(bank);
	}

	@GetMapping("/fetchBankById")
	public ResponseStructure<Bank> fetchBankById(@RequestParam int bankId) {
		return bankService.fetchBankById(bankId);
	}

	@PutMapping("/updateBank")
	public ResponseStructure<Bank> updateBank(@RequestParam int oldId, @RequestBody Bank newBank) {
		return bankService.updateBank(oldId, newBank);
	}

	@DeleteMapping("/deleteBankById")
	public ResponseStructure<Bank> deleteBankById(@RequestParam int bankId) {
		return bankService.deleteBankById(bankId);
	}

	@GetMapping("/fetchAllBanks")
	public ResponseStructureList<Bank> fetchAllBanks() {
		return bankService.fetchAllBanks();
	}

	@PutMapping("/addExistingBranchToExistingBank")
	public ResponseStructure<Bank> addExistingBranchToExistingBank(@RequestParam int branchId, @RequestParam int bankId) {
		return bankService.addExistingBranchToExistingBank(branchId, bankId);
	}

	@PutMapping("/addNewBranchToExistingBank")
	public ResponseStructure<Bank> addNewBranchToExistingBank(@RequestParam int bankId, @RequestBody Branch newBranch) {
		return bankService.addNewBranchToExistingBank(bankId, newBranch);
	}

	@PutMapping("/addExistingAtmsToExistingBank")
	public ResponseStructure<Bank> addExistingAtmsToExistingBank(@RequestParam int atmId, @RequestParam int bankId) {
		return bankService.addExistingAtmsToExistingBank(atmId, bankId);
	}
	@PutMapping("/addNewAtmToExistingBank")
	public ResponseStructure<Bank> addNewAtmToExistingBank(@RequestParam int bankId,@RequestBody Atm newAtm) {
		return bankService.addNewAtmToExistingBank(bankId, newAtm);
	}

}
