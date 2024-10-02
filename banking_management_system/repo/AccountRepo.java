package com.jsp.banking_management_system.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.banking_management_system.dto.Account;

public interface AccountRepo extends JpaRepository<Account, Integer>{

}
