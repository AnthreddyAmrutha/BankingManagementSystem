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
import com.jsp.banking_management_system.service.AtmService;
import com.jsp.banking_management_system.util.ResponseStructure;
import com.jsp.banking_management_system.util.ResponseStructureList;

@RestController
public class AtmController {

	@Autowired
	AtmService atmService;
    @PostMapping("/saveAtm")
	public ResponseStructure<Atm> saveAtm(@RequestBody Atm atm) {
		return atmService.saveAtm(atm);
	}
	@GetMapping("/fetchAtmById")
	public ResponseStructure<Atm> fetchAtmById(@RequestParam int atmId) {
		return atmService.fetchAtmById(atmId);
	}
	@PutMapping("/updateAtm")
	public ResponseStructure<Atm> updateAtm(@RequestParam int oldId,@RequestBody Atm newAtm) {
		return atmService.updateAtm(oldId, newAtm);
	}
	@DeleteMapping("/deleteAtmById")
	public ResponseStructure<Atm> deleteAtmById(@RequestParam int atmId) {
		return atmService.deleteAtmById(atmId);
	}
	@GetMapping("/fetchAllAtms")
	public ResponseStructureList<Atm> fetchAllAtms() {
		return atmService.fetchAllAtms();
	}
}
