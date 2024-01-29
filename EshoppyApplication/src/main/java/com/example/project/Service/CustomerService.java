package com.example.project.Service;

import org.springframework.stereotype.Service;

import com.example.project.Entity.Customer;

@Service
public interface CustomerService {
	
	String createrecords(Customer customer);
    String login(Long id,String name,String password);
  
}
