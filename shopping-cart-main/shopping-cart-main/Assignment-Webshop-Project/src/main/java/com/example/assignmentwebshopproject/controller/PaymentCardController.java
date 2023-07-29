package com.example.assignmentwebshopproject.controller;

import com.example.assignmentwebshopproject.business.impl.PayByCardUseCase;
import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.security.auth.isauthenticated.isAuthenticated;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/payments")
@AllArgsConstructor
@CrossOrigin( origins = "http://localhost:3000")
public class PaymentCardController {

    private final PayByCardUseCase payByCardUseCase;

    @isAuthenticated
    @RolesAllowed({"ROLE_CUSTOMER"})
    @PostMapping
    public ResponseEntity<PaymentByCardResponseDTO> createPayment(@RequestBody @Valid PaymentByCardRequestDTO request) {
        PaymentByCardResponseDTO response = payByCardUseCase.PaymentByCard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

}