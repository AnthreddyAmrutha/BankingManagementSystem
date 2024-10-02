package com.jsp.banking_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.jsp.banking_management_system.dao.BranchDao;
import com.jsp.banking_management_system.dto.Branch;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.dto.Employee;
import com.jsp.banking_management_system.exception.BranchIdNotFound;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@Service
public class BranchService {

	@Autowired
	BranchDao branchDao;

	@Autowired
	ResponseStructure<Branch> responseStructure;

	@Autowired
	ResponseStructureList<Branch> responseStructureList;

	public ResponseStructure<Branch> saveBranch(Branch branch) {
		responseStructure.setMessage("Successfully branch saved into DB");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setData(branchDao.saveBranch(branch));
		return responseStructure;
	}

	public ResponseStructure<Branch> fetchBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully branch fetched from DB");
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setData(branchDao.fetchBranchById(branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> updateBranch(int oldId, Branch newBranch) {
		Branch branch = branchDao.fetchBranchById(oldId);
		if (branch != null) {
			responseStructure.setMessage("Successfully branch updated in DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.updateBranch(oldId, newBranch));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructure<Branch> deleteBranchById(int branchId) {
		Branch branch = branchDao.fetchBranchById(branchId);
		if (branch != null) {
			responseStructure.setMessage("Successfully branch deleted from DB");
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setData(branchDao.deleteBranchById(branchId));
			return responseStructure;
		} else {
			throw new BranchIdNotFound();
		}
	}

	public ResponseStructureList<Branch> fetchAllBranchs() {
		responseStructureList.setMessage("Successfully fetched all branchs from DB");
		responseStructureList.setStatusCode(HttpStatus.FOUND.value());
		responseStructureList.setData(branchDao.fetchAllBranchs());
		return responseStructureList;
	}

	public ResponseStructure<Branch> addExistingManagerToExistingBranch(int managerId, int branchId) {
		responseStructure.setMessage("Successfully added Existing Manager To Existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingManagerToExistingBranch(managerId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingAddressToExistingBranch(int addressId, int branchId) {
		responseStructure.setMessage("Successfully added Existing Address To Existing Branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingAddressToExistingBranch(addressId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingCustomersToExistingBranch(int customerId, int branchId) {
		responseStructure.setMessage("Successfully added Existing customers To Existing branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingCustomersToExistingBranch(customerId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addNewCustomersToExistingBranch(int branchId, Customer newCustomer) {
		responseStructure.setMessage("Successfully added new customers To Existing branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewCustomersToExistingBranch(branchId, newCustomer));
		return responseStructure;
	}

	public ResponseStructure<Branch> addExistingEmployeesToExistingBranch(int employeeId, int branchId) {
		responseStructure.setMessage("Successfully added Existing employees To Existing branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addExistingEmployeesToExistingBranch(employeeId, branchId));
		return responseStructure;
	}

	public ResponseStructure<Branch> addNewEmployeesToExistingBranch(int branchId, Employee newEmployee) {
		responseStructure.setMessage("Successfully added new employees To Existing branch in DB");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setData(branchDao.addNewEmployeesToExistingBranch(branchId, newEmployee));
		return responseStructure;
	}

}
