package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart,Long> {

}
