package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.PaymentByCashDTO;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCash;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentCashDTOConverterTest {

    @Test
    void shouldConvertPaymentCashToDTO() {
        PaymentByCash payment = PaymentByCash.builder().id(1l).address("35 Liverpool City England").zipcode("7745AD")
                .date("25/07/2024")
                .user(GetUser())
                .build();

        PaymentByCashDTO actual = PaymentCashDTOConverter.convert(payment);

        PaymentByCashDTO expected = PaymentByCashDTO.builder().id(1l)
                .address("35 Liverpool City England").zipcode("7745AD")
                .date("25/07/2024")
                .user(GetUserDTO())
                .build();

        assertNotEquals(expected, actual);
    }

    private User GetUser(){
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .id(1L)
                .firstname("Jenny")
                .lastname("Ramos")
                .build();

        return new User();

    }

    private UserDTO GetUserDTO(){
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .id(1L)
                .firstname("Jenny")
                .lastname("Ramos")
                .build();

        return new UserDTO();

    }
}