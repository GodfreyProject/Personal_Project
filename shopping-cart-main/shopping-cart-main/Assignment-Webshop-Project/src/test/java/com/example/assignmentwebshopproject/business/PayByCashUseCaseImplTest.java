package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.config.exception.UserAlreadyExistsException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidOrderException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashRequestDTO;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.persistence.PayCardRepository;
import com.example.assignmentwebshopproject.persistence.PayCashRepository;
import com.example.assignmentwebshopproject.persistence.UserRepositoryTest;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCash;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PayByCashUseCaseImplTest {

    @Mock
    private PayCashRepository paycashRepositoryMock;

    @Mock
    private UserRepositoryTest userRepositoryMock;

    @InjectMocks
    private PayByCashUseCaseImpl payUseCaseMock;



    @Test
    void PaymentByCash_shouldThrowException_whenPaymentWithZipcode_AlreadyExists() {

        when(paycashRepositoryMock.existsByZipcode("7745AD")).thenReturn(true);

        PaymentByCashRequestDTO requestDTO = PaymentByCashRequestDTO.builder()
                .zipcode("7745AD")

                .build();

        UserAlreadyExistsException exceptionThrown = assertThrows(UserAlreadyExistsException.class, () -> {
            payUseCaseMock.PaymentByCash(requestDTO);
        });

        assertEquals("400 BAD_REQUEST \"PAYMENT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(paycashRepositoryMock).existsByZipcode("7745AD");

    }

    @Test
    void PaymentByCash_shouldThrowException_whenPaymentWithAddress_AlreadyExists() {

        when(paycashRepositoryMock.existsByAddress("65 Liverpool city England")).thenReturn(true);

        PaymentByCashRequestDTO requestDTO = PaymentByCashRequestDTO.builder()
                .address("65 Liverpool city England")

                .build();

        UserAlreadyExistsException exceptionThrown = assertThrows(UserAlreadyExistsException.class, () -> {
            payUseCaseMock.PaymentByCash(requestDTO);
        });

        assertEquals("400 BAD_REQUEST \"PAYMENT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(paycashRepositoryMock).existsByAddress("65 Liverpool city England");

    }

    @Test
    void PaymentByCash_shouldThrowException_whenPaymentDateAlreadyExists() {

        when(paycashRepositoryMock.existsByDate("25/07/2024")).thenReturn(true);

        PaymentByCashRequestDTO requestDTO = PaymentByCashRequestDTO.builder()
                .date("25/07/2024")

                .build();

        UserAlreadyExistsException exceptionThrown = assertThrows(UserAlreadyExistsException.class, () -> {
            payUseCaseMock.PaymentByCash(requestDTO);
        });
        assertEquals("400 BAD_REQUEST \"PAYMENT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(paycashRepositoryMock).existsByDate("25/07/2024");

    }



    @Test
    void createPaymentCash_shouldReturn201_WhenPaymentCashHasbeenCreated_Successful() {
        PaymentByCash requestDTO = PaymentByCash.builder()
                .id(2L)
                .address("65 Liverpool city England")
                .zipcode("7745AD")

                .user(GetUser())
                .totalAmount(1650)
                .build();

        PaymentByCardResponseDTO responseDTO = PaymentByCardResponseDTO.builder()
                .payByCardId(2L)

                .build();


        paycashRepositoryMock.save(requestDTO);

        assertThat(requestDTO.getId()).isEqualTo(2l);
    }

    private User GetUser(){
        SignUpRequestDTO signUpRequestDTO = SignUpRequestDTO.builder()
                .id(1L)
                .firstname("Jenny")
                .lastname("Ramos")
                .build();

        return new User();

    }

}