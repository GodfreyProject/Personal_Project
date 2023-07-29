package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.PaymentByCardDTO;
import com.example.assignmentwebshopproject.dto.ProductDTO;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.Product;


public final class PaymentCardDTOConverter {
    private PaymentCardDTOConverter(){
    }

    public static PaymentByCardDTO convert(PaymentByCard payment){
        return PaymentByCardDTO.builder()

                .address(payment.getAddress())
                .zipcode(payment.getZipcode())
                .ibanCardno(payment.getIbanCardno())
                .date(payment.getDate())
                .user(OrderUserDTOConverter.convertUserToDTO(payment.getUser()))
               .build();

    }
}
