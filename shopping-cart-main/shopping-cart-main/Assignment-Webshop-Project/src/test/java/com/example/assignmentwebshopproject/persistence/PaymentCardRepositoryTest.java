package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.dto.ShoppingCartRequest;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class PaymentCardRepositoryTest {

    @Mock
    private PayCardRepository paymentRepositoryMock;


    @Test
    void Should_SaveNewProduct_Using_PayCardRespositoryTest() {

        PaymentByCard card = PaymentByCard.builder().id(1L).address("25 Garden Street Breda").zipcode("7564AD").ibanCardno("NL45663774856456")
                .date("25/10/2024").user(GetUser()).totalAmount(1256.70).build();

        paymentRepositoryMock.save(card);

        assertThat(card.getId()).isEqualTo(1);
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
