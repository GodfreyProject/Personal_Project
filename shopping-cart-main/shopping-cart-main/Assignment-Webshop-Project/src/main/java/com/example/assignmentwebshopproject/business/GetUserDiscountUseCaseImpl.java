package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.GetUserDiscountUseCase;
import com.example.assignmentwebshopproject.business.impl.UserIdValidator;
import com.example.assignmentwebshopproject.config.exception.userNotFoundException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.AccessTokenDTO;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class GetUserDiscountUseCaseImpl implements GetUserDiscountUseCase {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    private final UserRepository userRepository;
    private final UserIdValidator userIdValidator;

    private final AccessTokenDTO requestAccessToken;

    public Double getUserDiscount(List<ShoppingCart> shoppingCartList) {
        Double totalCartAmount = Double.valueOf(0f);
        double singleCartAmount = 0f;
        int availableQuantity = 0;

        for (ShoppingCart cart : shoppingCartList) {

            int productId = Math.toIntExact(cart.getProductId());
            Optional<Product> product = productRepository.findById((long) productId);


             // Optional<Product> product = productRepository.findById(item.getProductId());
              if(product.isPresent() && cart.getQuantity() > 5) {
                  totalCartAmount += product.get().getPrice() * cart.getQuantity()/30;

              }else {
                  throw  new InvalidUserException("YOU_MUST_ORDER_5_QUANTITY_TO_GET_DISCOUNT");
              }
          }
          return totalCartAmount;

        }
        //return totalCartAmount;
    }



