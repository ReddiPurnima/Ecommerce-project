package com.example.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Supplier;
import com.example.project.Repository.SupplierRepository;

@Service
public class SupplierRegisterService {
	
	@Autowired
	private SupplierRepository suprepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Supplier findByEmail(String email) {
		return suprepo.findByEmail(email);
		}
	public ResponseEntity<String> savesupplier(Supplier supplier) {
		 
	     if (suprepo.existsByEmail(supplier.getEmail())) {
	         return ResponseEntity.badRequest().body("Email already registered");

	     }

	   	     supplier.setPassword(passwordEncoder.encode(supplier.getPassword()));
	        	     suprepo.save(supplier);
	     return ResponseEntity.ok("customer registered successfully");

	}


}


