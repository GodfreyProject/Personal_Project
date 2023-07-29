package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.config.exception.AlreadyExistsExceptionMessage;
import com.example.assignmentwebshopproject.config.exception.UserAlreadyExistsException;
import com.example.assignmentwebshopproject.dto.CreateOrderResponseDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.PayCardRepository;
import com.example.assignmentwebshopproject.persistence.ShoppingCartRepository;
import com.example.assignmentwebshopproject.persistence.UserRepositoryTest;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
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
class PayByCardUseCaseImplTest {

    @Mock
    private PayCardRepository payRepositoryMock;

    @Mock
    private UserRepositoryTest userRepositoryMock;

    @InjectMocks
    private PayByCardUseCaseImpl payUseCaseMock;


    @Test
    void PaymentByCard_shouldThrowException_whenPaymentAddressAlreadyExists() {

        when(payRepositoryMock.existsByAddress("25 Garden-City Eindhoven")).thenReturn(true);

        PaymentByCardRequestDTO requestDTO = PaymentByCardRequestDTO.builder()
                .address("25 Garden-City Eindhoven")

                .build();

        UserAlreadyExistsException exceptionThrown = assertThrows(UserAlreadyExistsException.class, () -> {
            payUseCaseMock.PaymentByCard(requestDTO);
        });
        assertEquals("400 BAD_REQUEST \"PAYMENT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(payRepositoryMock).existsByAddress("25 Garden-City Eindhoven");

    }

    @Test
    void PaymentByCard_shouldThrowException_whenPaymentZipcodeAlreadyExists() {

        when(payRepositoryMock.existsByZipcode("7565JD")).thenReturn(true);

        PaymentByCardRequestDTO requestDTO = PaymentByCardRequestDTO.builder()
                .zipcode("7565JD")

                .build();

        UserAlreadyExistsException exceptionThrown = assertThrows(UserAlreadyExistsException.class, () -> {
            payUseCaseMock.PaymentByCard(requestDTO);
        });
        assertEquals("400 BAD_REQUEST \"PAYMENT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(payRepositoryMock).existsByZipcode("7565JD");

    }


    @Test
    void PaymentByCard_shouldThrowException_whenPaymentIBanCardrNoAlreadyExists() {

        when(payRepositoryMock.existsByIbanCardno("NL3567766548790")).thenReturn(true);

        PaymentByCardRequestDTO requestDTO = PaymentByCardRequestDTO.builder()
                .ibanCardno("NL3567766548790")

                .build();

        UserAlreadyExistsException exceptionThrown = assertThrows(UserAlreadyExistsException.class, () -> {
            payUseCaseMock.PaymentByCard(requestDTO);
        });
        assertEquals("400 BAD_REQUEST \"PAYMENT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(payRepositoryMock).existsByIbanCardno("NL3567766548790");

    }

    @Test
    void createPaymentCard_shouldReturn201_WhenPaymentHasCreated_Successful() {
        PaymentByCard requestDTO = PaymentByCard.builder()
                .id(1L)
                .address("25 Garden-City Eindhoven")
                .zipcode("7565JD")
                .ibanCardno("NL3567766548790")
                .user(GetUser())
                .totalAmount(1650)
                .build();



        PaymentByCardResponseDTO responseDTO = PaymentByCardResponseDTO.builder()
                .payByCardId(1L)

                .build();


        payRepositoryMock.save(requestDTO);

        assertThat(requestDTO.getId()).isEqualTo(1l);
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