package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.dto.SignUpResponseDTO;


public interface PayByCardUseCase {
    PaymentByCardResponseDTO PaymentByCard(PaymentByCardRequestDTO request);
}
