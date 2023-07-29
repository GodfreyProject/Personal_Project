package com.example.assignmentwebshopproject.controller;

import com.example.assignmentwebshopproject.business.impl.PayByCardUseCase;
import com.example.assignmentwebshopproject.business.impl.PayByCashUseCase;
import com.example.assignmentwebshopproject.dto.PaymentByCardRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCardResponseDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashRequestDTO;
import com.example.assignmentwebshopproject.dto.PaymentByCashResponseDTO;
import com.example.assignmentwebshopproject.security.auth.isauthenticated.isAuthenticated;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/payCash")
@CrossOrigin( origins = "http://localhost:3000")
@AllArgsConstructor
public class PaymentCashController {

    private final PayByCashUseCase payByCashUseCase;


    @isAuthenticated
    @RolesAllowed({"ROLE_CUSTOMER"})
    @PostMapping
    public ResponseEntity<PaymentByCashResponseDTO> createPayment(@RequestBody @Valid PaymentByCashRequestDTO request) {
        PaymentByCashResponseDTO response = payByCashUseCase.PaymentByCash(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }

}