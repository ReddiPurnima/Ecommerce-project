package com.example.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findByPriceBetween(double minPrice,double maxPrice);
	List<Product> findByPrice(double price);
	List<Product> findByCategory(String category);
}

