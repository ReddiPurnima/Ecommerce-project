package com.example.project.Service;

import org.springframework.stereotype.Service;

import com.example.project.Entity.Product;
import com.example.project.Entity.Supplier;

@Service
public interface SupplierService {

	//String createrecords(Supplier supplier);

	String createrecords(Supplier supplier);
	String login(Long id,String name,String password);
	String addProductForSupplier(Long supplierId, Product product);
}
