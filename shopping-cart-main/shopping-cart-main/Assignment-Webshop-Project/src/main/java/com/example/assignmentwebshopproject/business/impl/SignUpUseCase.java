package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.dto.SignUpResponseDTO;


public interface SignUpUseCase {
    SignUpResponseDTO signUp(SignUpRequestDTO request);
}
