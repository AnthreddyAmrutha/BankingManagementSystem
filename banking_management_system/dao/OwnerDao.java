package com.jsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.banking_management_system.dto.Bank;
import com.jsp.banking_management_system.dto.Owner;
import com.jsp.banking_management_system.repo.BankRepo;
import com.jsp.banking_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {

	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired 
	BankDao bankDao;
	
	public Owner saveOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	public Owner fetchOwnerById(int ownerId) {
		Optional<Owner> owner= ownerRepo.findById(ownerId);
		if(owner.isPresent()) {
			return owner.get();
		}
		else {
			return null;
		}
	}
	
	public Owner updateOwner(int oldId,Owner newOwner) {
		newOwner.setOwnerId(oldId);
		return saveOwner(newOwner);
	}
	
	public Owner deleteOwnerById(int ownerId) {
		Owner owner=fetchOwnerById(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public List<Owner> fetchAllOwners() {
		return ownerRepo.findAll();
	}
	
	public Owner addExistingBankToExistingOwner(int bankId,int ownerId) {
		
		Bank bank=bankDao.fetchBankById(bankId);
		Owner owner=fetchOwnerById(ownerId);
		owner.setBank(bank);
		return saveOwner(owner);
	}
}
