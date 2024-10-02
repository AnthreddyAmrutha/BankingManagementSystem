package com.jsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.banking_management_system.dto.Address;
import com.jsp.banking_management_system.dto.Branch;
import com.jsp.banking_management_system.dto.Customer;
import com.jsp.banking_management_system.dto.Employee;
import com.jsp.banking_management_system.dto.Manager;
import com.jsp.banking_management_system.repo.BranchRepo;

@Repository
public class BranchDao {

	@Autowired
	BranchRepo branchRepo;
	
	@Autowired
	ManagerDao managerDao;
	
	@Autowired
	AddressDao addressDao;
	
	
	@Autowired
	CustomerDao customerDao;

	@Autowired
	EmployeeDao employeeDao;
	
	public Branch saveBranch(Branch branch) {
		return branchRepo.save(branch);
	}
	
	public Branch fetchBranchById(int branchId) {
		Optional<Branch> branch= branchRepo.findById(branchId);
		if(branch.isPresent()) {
			return branch.get();
		}
		else {
			return null;
		}
	}
	
	public Branch updateBranch(int oldId,Branch newBranch) {
		newBranch.setBranchId(oldId);
		return saveBranch(newBranch);
	}
	
	public Branch deleteBranchById(int branchId) {
		Branch branch=fetchBranchById(branchId);
		branchRepo.delete(branch);
		return branch;
	}
	
	public List<Branch> fetchAllBranchs() {
		return branchRepo.findAll();
	}
	
	public Branch addExistingManagerToExistingBranch(int managerId,int branchId) {
		Manager manager=managerDao.fetchManagerById(managerId);
		Branch branch=fetchBranchById(branchId);
		branch.setManager(manager);
		return saveBranch(branch);
	}
	
	public Branch addExistingAddressToExistingBranch(int addressId,int branchId) {
		Address address=addressDao.fetchAddressById(addressId);
		Branch branch=fetchBranchById(branchId);
		branch.setAddress(address);
		return saveBranch(branch);
	}
	
	public Branch addExistingCustomersToExistingBranch(int customerId,int branchId)
	{
		Customer customer=customerDao.fetchCustomerById(customerId);
		Branch branch=fetchBranchById(branchId);
		List<Customer> list= branch.getCustomer();
		list.add(customer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
	
	public Branch addNewCustomersToExistingBranch(int branchId,Customer newCustomer)
	{
		Branch branch=fetchBranchById(branchId);
		List<Customer> list= branch.getCustomer();
		list.add(newCustomer);
		branch.setCustomer(list);
		return saveBranch(branch);
	}
	

	public Branch addExistingEmployeesToExistingBranch(int employeeId,int branchId) {
		Employee employee=employeeDao.fetchEmployeeById(employeeId);
		Branch branch=fetchBranchById(branchId);
		List<Employee> list=branch.getEmployee();
		list.add(employee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	public Branch addNewEmployeesToExistingBranch(int branchId,Employee newEmployee)
	{
		Branch branch=fetchBranchById(branchId);
		List<Employee> list= branch.getEmployee();
		list.add(newEmployee);
		branch.setEmployee(list);
		return saveBranch(branch);
	}
	
	
}
