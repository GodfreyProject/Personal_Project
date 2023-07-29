package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.OrderDTO;
import com.example.assignmentwebshopproject.persistence.entity.Order;

public final class OrderDTOConverter {
    private OrderDTOConverter() {
    }

    public static OrderDTO convertOrderToDTO(Order newOrder) {

        return OrderDTO.builder()
                .orderId(newOrder.getId())
                .orderDescription(newOrder.getOrderDescription())
                .cartItems(newOrder.getCartItems())
                .user(OrderUserDTOConverter.convertUserToDTO(newOrder.getUser()))
                .TotalAmount(newOrder.getTotalPrice())
                .build();


    }

}