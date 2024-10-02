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

import com.jsp.banking_management_system.dto.Branch;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.dto.Employee;
import com.jsp.banking_management_system.service.BranchService;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	@GetMapping("/fetchBranchById")
	public ResponseStructure<Branch> fetchBranchById(@RequestParam int branchId) {
		return branchService.fetchBranchById(branchId);
	}

	@PutMapping("/updateBranch")
	public ResponseStructure<Branch> updateBranch(@RequestParam int oldId, @RequestBody Branch newBranch) {
		return branchService.updateBranch(oldId, newBranch);
	}

	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	@GetMapping("/fetchAllBranchs")
	public ResponseStructureList<Branch> fetchAllBranchs() {
		return branchService.fetchAllBranchs();
	}

	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int managerId, @RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}

	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int addressId, @RequestParam int branchId) {
		return branchService.addExistingAddressToExistingBranch(addressId, branchId);
	}

	@PutMapping("/addExistingCustomersToExistingBranch")
	public ResponseStructure<Branch> addExistingCustomersToExistingBranch(@RequestParam int customerId, @RequestParam int branchId) {
		return branchService.addExistingCustomersToExistingBranch(customerId, branchId);
	}

	@PutMapping("/addNewCustomersToExistingBranch")
	public ResponseStructure<Branch> addNewCustomersToExistingBranch(@RequestParam int branchId, @RequestBody Customer newCustomer) {
		return branchService.addNewCustomersToExistingBranch(branchId, newCustomer);
	}
	
	@PutMapping("/addExistingEmployeesToExistingBranch")
	public ResponseStructure<Branch> addExistingEmployeesToExistingBranch(@RequestParam int employeeId,@RequestParam int branchId) {
		return branchService.addExistingEmployeesToExistingBranch(employeeId, branchId);
	}
	
	@PutMapping("/addNewEmployeesToExistingBranch")
	public ResponseStructure<Branch> addNewEmployeesToExistingBranch(@RequestParam int branchId,@RequestBody Employee newEmployee) {
		return branchService.addNewEmployeesToExistingBranch(branchId, newEmployee);
	}

}
