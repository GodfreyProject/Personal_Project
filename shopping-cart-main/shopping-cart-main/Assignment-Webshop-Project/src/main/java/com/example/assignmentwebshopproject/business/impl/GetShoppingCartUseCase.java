package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.configuration.exception.userNotFoundException;
import com.example.assignmentwebshopproject.dto.ShoppingCartDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;

import java.util.Optional;

public interface GetShoppingCartUseCase {

    public Optional<ShoppingCartDTO> getShoppingCart(Long Id) throws userNotFoundException;
}
