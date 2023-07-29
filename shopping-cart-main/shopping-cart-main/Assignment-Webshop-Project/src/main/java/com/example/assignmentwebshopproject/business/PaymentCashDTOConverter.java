package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.PaymentByCardDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashDTO;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCard;
import com.example.assignmentwebshopproject.persistence.entity.PaymentByCash;


public final class PaymentCashDTOConverter {
    private PaymentCashDTOConverter(){
    }

    public static PaymentByCashDTO convert(PaymentByCash payment){
        return PaymentByCashDTO.builder()

                .address(payment.getAddress())
                .zipcode(payment.getZipcode())

                .date(payment.getDate())
                .cartTotal(payment.getTotalAmount())
                .user(OrderUserDTOConverter.convertUserToDTO(payment.getUser()))
               .build();

    }
}
