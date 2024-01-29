package com.example.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.project.Entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{

	boolean existsByProductId(Long productId);

	Optional<CartItem> findByProductId(Long productId);

}
