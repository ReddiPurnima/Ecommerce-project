package com.example.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.project.Entity.Customer;
import com.example.project.Repository.CustomerRepository;

@Service
public class Registerclass {
	
 @Autowired
	private CustomerRepository cusrepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Customer findByEmail(String email) {
		return cusrepo.findByEmail(email);
		}
	public ResponseEntity<String> savecustomer(Customer customer) {
		 
	     if (cusrepo.existsByEmail(customer.getEmail())) {
	         return ResponseEntity.badRequest().body("Email already registered");

	     }

	   	     customer.setPassword(passwordEncoder.encode(customer.getPassword()));
	        	     cusrepo.save(customer);
	     return ResponseEntity.ok("customer registered successfully");

	}


}


