package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.persistence.entity.Order;

import com.example.assignmentwebshopproject.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    boolean existsByOrderDescription(String orderDescription);

    boolean existsById(Long orderId);



}
