package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.CreateOrderUseCase;
import com.example.assignmentwebshopproject.business.impl.UserIdValidator;
import com.example.assignmentwebshopproject.config.exception.AlreadyExistsExceptionMessage;
import com.example.assignmentwebshopproject.dto.CreateOrderRequestDTO;
import com.example.assignmentwebshopproject.dto.CreateOrderResponseDTO;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.util.DateUtil;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final UserIdValidator userIdValidator;

    @Override
    public CreateOrderResponseDTO createNewOrder(CreateOrderRequestDTO request) {
        if (orderRepository.existsByOrderDescription(request.getOrderDescription())) {
            throw new AlreadyExistsExceptionMessage();
        }

        userIdValidator.validateId(request.getUserId());

        Order savedOrder = saveNewOrder(request);

        return CreateOrderResponseDTO.builder()
                .orderId(savedOrder.getId())

                .build();



    }

    private Order saveNewOrder(CreateOrderRequestDTO request) {
        User userEntity = userRepository.findById(request.getUserId()).get();
           // countryEntity.
        Order newOrder = Order.builder()
                .user(userEntity)
                .id(request.getId())
                .orderDescription(request.getOrderDescription())
                .cartItems(request.getCartItems())


                .build();
        return orderRepository.save(newOrder);
    }
}
