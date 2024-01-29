package com.example.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Supplier;
@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long>{
	Supplier findByEmail(String email);
	  boolean existsByEmail(String email);
}
