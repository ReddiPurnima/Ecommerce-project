package com.example.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.Entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

}
