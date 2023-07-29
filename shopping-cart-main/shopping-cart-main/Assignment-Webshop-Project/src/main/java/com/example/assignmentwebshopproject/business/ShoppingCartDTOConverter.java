package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.ShoppingCartDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.dto.UserRoleDTO;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;

import java.util.HashSet;
import java.util.Set;

public final class ShoppingCartDTOConverter {
    private ShoppingCartDTOConverter() {
    }

    public static ShoppingCartDTO convertShoppingToDTO(ShoppingCart cart) {

                return  ShoppingCartDTO.builder()
                        .id(cart.getId())
                        .productId(cart.getProductId())
                        .productName(cart.getProductName())
                        .quantity(cart.getQuantity())
                        .amount(cart.getAmount())

                .build();


    }

}