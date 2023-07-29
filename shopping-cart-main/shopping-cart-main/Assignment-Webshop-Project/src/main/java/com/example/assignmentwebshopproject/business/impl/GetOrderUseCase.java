package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.OrderDTO;

import java.util.Optional;

public interface GetOrderUseCase {

    public Optional<OrderDTO> getOrderDetail(Long orderId);
}
