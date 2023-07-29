package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.dto.ShoppingCartRequest;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.persistence.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class OrderRepositoryTest {

    @Mock
    private OrderRepository orderRepositoryMock;


    @Test
    void Should_SaveNewProduct_Using_OrderRespositoryTest() {

        Order sneakers = Order.builder().id(1L).orderDescription("Milano New Collections").user(GetUser()).cartItems(CartItems()).totalAmount(1256.70).build();

        orderRepositoryMock.save(sneakers);

        assertThat(sneakers.getId()).isEqualTo(1);
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

}
