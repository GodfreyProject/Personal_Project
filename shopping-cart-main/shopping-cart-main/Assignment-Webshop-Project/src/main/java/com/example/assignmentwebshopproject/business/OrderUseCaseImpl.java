package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.OrderUseCase;
import com.example.assignmentwebshopproject.business.impl.UserIdValidator;
import com.example.assignmentwebshopproject.config.exception.AlreadyExistsExceptionMessage;
import com.example.assignmentwebshopproject.config.exception.InvalidCredentialsException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.AccessTokenDTO;
import com.example.assignmentwebshopproject.dto.CreateOrderRequestDTO;
import com.example.assignmentwebshopproject.dto.CreateOrderResponseDTO;
import com.example.assignmentwebshopproject.dto.OrderDTO;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.*;
import com.example.assignmentwebshopproject.security.auth.UnauthorizedDataAccessException;
import com.example.assignmentwebshopproject.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderUseCaseImpl implements OrderUseCase {

    private  final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final UserRepository userRepository;
    private final UserIdValidator userIdValidator;

    private final AccessTokenDTO requestAccessToken;







    public Double getCartAmount(List<ShoppingCart> shoppingCartList) {

          Double totalCartAmount = 0.0;


        double singleCartAmount = 0f;
        int availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList) {

            int productId = Math.toIntExact(cart.getProductId());
            Optional<Product> product = productRepository.findById((long) productId);
            if (product.isPresent()) {
                Product product1 = product.get();
                if (product1.getAvailablequantity() < cart.getQuantity()) {
                    singleCartAmount = product1.getPrice() * product1.getAvailablequantity();
                    cart.setQuantity(product1.getAvailablequantity());
                } else {
                    singleCartAmount = cart.getQuantity() * product1.getPrice();
                    availableQuantity = product1.getAvailablequantity() - cart.getQuantity();
                }
                totalCartAmount = totalCartAmount + singleCartAmount;
                product1.setAvailablequantity(availableQuantity);
                availableQuantity=0;
                cart.setProductName(product1.getName());
                cart.setAmount((Double) singleCartAmount);

                productRepository.save(product1);
            }
        }
        return  totalCartAmount;
    }

    @Override
    public CreateOrderResponseDTO createNewOrder(CreateOrderRequestDTO request) {
        if (orderRepository.existsByOrderDescription(request.getOrderDescription())) {
            throw new AlreadyExistsExceptionMessage();
        }

            if (requestAccessToken.getUserId() != request.getUserId()) {
                throw new UnauthorizedDataAccessException("STUDENT_ID_NOT_FROM_LOGGED_IN_USER");
            }


            userIdValidator.validateId(request.getUserId());

        Order savedOrder = saveNewOrder(request);

        return CreateOrderResponseDTO.builder()
                .orderId(savedOrder.getId())
                .totalAmount(savedOrder.getTotalAmount())
                .build();

    }



    private Order saveNewOrder(CreateOrderRequestDTO request) {
        User userEntity = userRepository.findById(request.getUserId()).get();

        Order newOrder = Order.builder()
                .id(request.getId())
                .user(userEntity)
                .orderDescription(request.getOrderDescription())
                .cartItems(request.getCartItems())
                .totalAmount(request.getTotalAmount())
                //.(request.getTotalPrice())
                .build();
        return orderRepository.save(newOrder);
    }


    }













