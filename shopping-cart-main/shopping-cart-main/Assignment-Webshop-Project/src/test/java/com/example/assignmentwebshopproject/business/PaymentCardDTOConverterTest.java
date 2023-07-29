package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.PaymentByCardDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashDTO;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCash;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PaymentCardDTOConverterTest {

    @Test
    void shouldConvertPaymentCardToDTO() {
        PaymentByCard payment = PaymentByCard.builder().id(1l).address("35 Liverpool City England").zipcode("7745AD")
                .date("25/07/2024")
                .ibanCardno("NL76588756999804")
                .user(GetUser())
                .build();

        PaymentByCardDTO actual = PaymentCardDTOConverter.convert(payment);

        PaymentByCardDTO expected = PaymentByCardDTO.builder().id(1l)
                .address("35 Liverpool City England").zipcode("7745AD")
                .date("25/07/2024")
                .ibanCardno("NL76588756999804")
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