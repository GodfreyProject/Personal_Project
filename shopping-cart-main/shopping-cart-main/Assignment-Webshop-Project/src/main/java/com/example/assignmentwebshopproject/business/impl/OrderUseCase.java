package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.CreateOrderRequestDTO;
import com.example.assignmentwebshopproject.dto.CreateOrderResponseDTO;
import com.example.assignmentwebshopproject.dto.OrderDTO;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;

import java.util.List;
import java.util.Optional;

public interface OrderUseCase {

    // Get Customer Order by Id;


    public Double getCartAmount(List<ShoppingCart> shoppingCartList);

    CreateOrderResponseDTO createNewOrder(CreateOrderRequestDTO request);
}
