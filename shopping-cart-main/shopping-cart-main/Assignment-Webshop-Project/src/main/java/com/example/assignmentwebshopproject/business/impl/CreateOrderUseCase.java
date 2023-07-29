package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.CreateOrderRequestDTO;
import com.example.assignmentwebshopproject.dto.CreateOrderResponseDTO;

public interface CreateOrderUseCase {
    CreateOrderResponseDTO createNewOrder(CreateOrderRequestDTO request);
}
