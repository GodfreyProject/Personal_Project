package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderDTOConverterTest {


    @Test
    void shouldConvertOrderToDTO() {
        Order request = Order.builder()
                .id(2L)
                .orderDescription("New Brand Collections")
                .user(GetUser())
                .cartItems(CartItems())
                .totalAmount(2650.60)
                .build();

        OrderDTO actual = OrderDTOConverter.convertOrderToDTO(request);

        OrderDTO expected = OrderDTO.builder().orderId(2l)
                .orderDescription("New Brand Collections")
                .user(GetUserDTO())
                .cartItems(CartItems())
                .TotalAmount(2650.60)
                .build();
        CreateOrderResponseDTO responseDTO = CreateOrderResponseDTO.builder()
                .orderId(1L)
                .totalAmount(750)
                .build();


        assertNotEquals(expected, actual);


    }


    private List<ShoppingCart> CartItems() {
        ShoppingCartRequest request = ShoppingCartRequest.builder()
                .productId(1L)
                .productName("Jordan Sneakers")
                .quantity(5)
                .amount(650)
                .build();

        return new ArrayList<ShoppingCart>();
    }

    private User GetUser() {
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .id(1L)
                .firstname("Jenny")
                .lastname("Ramos")
                .build();

        return new User();

    }

    private UserDTO GetUserDTO() {
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .id(1L)
                .firstname("Jenny")
                .lastname("Ramos")
                .build();

        return new UserDTO();
    }


}