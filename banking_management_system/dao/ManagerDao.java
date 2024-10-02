package com.jsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.banking_management_system.dto.Manager;
import com.jsp.banking_management_system.repo.ManagerRepo;

@Repository
public class ManagerDao {

	@Autowired
	ManagerRepo managerRepo;
	
	public Manager saveManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public Manager fetchManagerById(int managerId) {
		Optional<Manager> manager=managerRepo.findById(managerId);
		if(manager.isPresent()) {
			return manager.get();
		}
		else {
			return null;
		}
	}
	
	public Manager updateManager(int oldId,Manager newManager) {
		newManager.setManagerId(oldId);
		return saveManager(newManager);
	}
	
	public Manager deleteManagerById(int managerId) {
		Manager manager=fetchManagerById(managerId);
		managerRepo.delete(manager);
		return manager;
	}
	
	public List<Manager> fetchAllManagers() {
		return managerRepo.findAll();
	}
}
