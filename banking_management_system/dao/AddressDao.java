package com.jsp.banking_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.banking_management_system.dto.Address;
import com.jsp.banking_management_system.repo.AddressRepo;

@Repository
public class AddressDao {

	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address address) {
		return addressRepo.save(address);
	}
	
	public Address fetchAddressById(int addressId) {
		Optional<Address> addresss=addressRepo.findById(addressId);
		if(addresss.isPresent()) {
			return addresss.get();
		}
		else {
			return null;
		}
	}
	
	public Address updateAddress(int oldId,Address newAddress) {
		newAddress.setAddressId(oldId);
		return saveAddress(newAddress);
	}
	
	public Address deleteAddressById(int addressId) {
		Address address=fetchAddressById(addressId);
		addressRepo.delete(address);
		return address;
	}
	
	public List<Address> fetchAllAddress() {
		return addressRepo.findAll();
	}
}
