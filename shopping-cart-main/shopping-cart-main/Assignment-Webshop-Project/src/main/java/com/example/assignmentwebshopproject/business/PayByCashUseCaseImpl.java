package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.PayByCardUseCase;
import com.example.assignmentwebshopproject.business.impl.PayByCashUseCase;
import com.example.assignmentwebshopproject.config.exception.UserAlreadyExistsException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidOrderException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.PayCardRepository;
import com.example.assignmentwebshopproject.persistence.PayCashRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCash;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.security.auth.UnauthorizedDataAccessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayByCashUseCaseImpl implements PayByCashUseCase {

    private final PayCashRepository payCashRepository;

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final AccessTokenDTO requestAccessToken;
    @Override
    public PaymentByCashResponseDTO PaymentByCash(PaymentByCashRequestDTO request) {


         if (payCashRepository.existsByAddress(request.getAddress())) {
            throw new UserAlreadyExistsException();
        }
       else if (payCashRepository.existsByDate(request.getDate())) {
            throw new UserAlreadyExistsException();
        }
       else if(payCashRepository.existsByZipcode(request.getZipcode()))
        {
            throw new UserAlreadyExistsException();
        }






        PaymentByCash savedPayment = saveNewPayment(request);

        return PaymentByCashResponseDTO.builder()
                .payByCashId(savedPayment.getId())

                .build();
    }


    private PaymentByCash saveNewPayment(PaymentByCashRequestDTO  request) {

        User userEntity = userRepository.findById(request.getUserId()).get();
        PaymentByCash newPayment = PaymentByCash.builder()

                .user(userEntity)

                .address(request.getAddress())
                .zipcode(request.getZipcode())
                .date(request.getDate())
                .totalAmount(request.getTotalAmount())
                .build();
        return payCashRepository.save(newPayment);
    }
}
