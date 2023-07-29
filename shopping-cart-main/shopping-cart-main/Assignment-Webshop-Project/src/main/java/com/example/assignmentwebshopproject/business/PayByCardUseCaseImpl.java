package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.AccessTokenEncoder;
import com.example.assignmentwebshopproject.business.impl.PayByCardUseCase;
import com.example.assignmentwebshopproject.config.exception.UserAlreadyExistsException;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.AccessTokenDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.PayCardRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.UserRoleRepository;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.security.auth.UnauthorizedDataAccessException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PayByCardUseCaseImpl implements PayByCardUseCase {

    private final PayCardRepository payCardRepository;

    private final OrderRepository orderRepository;

    private final UserRepository userRepository;

    private final AccessTokenDTO requestAccessToken;
    @Override
    public PaymentByCardResponseDTO PaymentByCard(PaymentByCardRequestDTO request) {

        if(payCardRepository.existsByZipcode(request.getZipcode())) {

            throw new UserAlreadyExistsException();
        }
        if (payCardRepository.existsByAddress(request.getAddress())) {
            throw new UserAlreadyExistsException();
        }

        if(payCardRepository.existsByIbanCardno(request.getIbanCardno()))

        {
            throw new UserAlreadyExistsException();
        }



        PaymentByCard savedPayment = saveNewOrder(request);

        return PaymentByCardResponseDTO.builder()
                .payByCardId(savedPayment.getId())
                .build();
    }


    private PaymentByCard saveNewOrder(PaymentByCardRequestDTO  request) {

        User userEntity = userRepository.findById(request.getUserId()).get();
        PaymentByCard newPayment = PaymentByCard.builder()

                .user(userEntity)

                .address(request.getAddress())
                .zipcode(request.getZipcode())
                .ibanCardno(request.getIbanCardno())
                .date(request.getDate())
                .totalAmount(request.getTotalAmount())
                .build();
        return payCardRepository.save(newPayment);
    }
}
