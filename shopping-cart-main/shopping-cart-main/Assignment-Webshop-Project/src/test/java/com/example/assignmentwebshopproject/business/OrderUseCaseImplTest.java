package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.config.exception.AlreadyExistsExceptionMessage;
import com.example.assignmentwebshopproject.config.exception.ProductAlreadyExistsException;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.ShoppingCartRepository;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;

@ExtendWith(MockitoExtension.class)
class OrderUseCaseImplTest {

    @Mock
    private OrderRepository orderRepositoryMock;

    @Mock
    private ShoppingCartRepository shoppingcartRepositoryMock;

    @InjectMocks
    private OrderUseCaseImpl orderUseCaseMock;


    @InjectMocks
    private GetShoppingCartUseCaseImpl shoppingUseCaseMock;


    @Test
    void createOrder_shouldThrowException_whenOrderDescriptionAlreadyExists() {

        when(orderRepositoryMock.existsByOrderDescription("New Brand Collections")).thenReturn(true);

        CreateOrderRequestDTO request = CreateOrderRequestDTO.builder()
                .orderDescription("New Brand Collections")

                .build();

        AlreadyExistsExceptionMessage exceptionThrown = assertThrows(AlreadyExistsExceptionMessage.class, () -> {
            orderUseCaseMock.createNewOrder(request);
        });

        assertEquals("400 BAD_REQUEST \"ALREADY_EXISTS_INFORMATION\"", exceptionThrown.getMessage());
        verify(orderRepositoryMock).existsByOrderDescription("New Brand Collections");

    }

    @Test
    void createNewOrder_shouldReturn201_WhenOrderHasCreated_Successful() {

        Order request = Order.builder()
                .id(1L)
                .orderDescription("New Brand Collections")
                .user(GetUser())
                .cartItems(CartItems())
                .totalAmount(650)
                .build();



        CreateOrderResponseDTO responseDTO = CreateOrderResponseDTO.builder()
                .orderId(1L)
                .totalAmount(750)
                .build();


        orderRepositoryMock.save(request);

        assertThat(request.getId()).isEqualTo(1L);


    }



    private List<ShoppingCart> CartItems(){
            ShoppingCartRequest request = ShoppingCartRequest.builder()
                    .productId(1L)
                    .productName("Jordan Sneakers")
                    .quantity(5)
                    .amount(650)
                    .build();

            return new ArrayList<ShoppingCart>();
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


