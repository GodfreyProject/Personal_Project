package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashResponseDTO;


public interface PayByCashUseCase {
    PaymentByCashResponseDTO PaymentByCash(PaymentByCashRequestDTO request);
}
