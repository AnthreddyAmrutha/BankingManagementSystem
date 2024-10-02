package com.jsp.banking_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int accountId;
		private String accountType;
		private long accountNumber;
		private double minimumBalance;
		private double dialyLimit;
		
		public int getAccountId() {
			return accountId;
		}
		public void setAccountId(int accountId) {
			this.accountId = accountId;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public double getMinimumBalance() {
			return minimumBalance;
		}
		public void setMinimumBalance(double minimumBalance) {
			this.minimumBalance = minimumBalance;
		}
		public double getDialyLimit() {
			return dialyLimit;
		}
		public void setDialyLimit(double dialyLimit) {
			this.dialyLimit = dialyLimit;
		}
}
