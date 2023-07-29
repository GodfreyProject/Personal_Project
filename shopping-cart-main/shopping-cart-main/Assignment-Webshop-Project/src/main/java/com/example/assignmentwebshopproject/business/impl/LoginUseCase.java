package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.LoginRequestDTO;
import com.example.assignmentwebshopproject.dto.LoginResponseDTO;

public interface LoginUseCase {
    LoginResponseDTO login(LoginRequestDTO request);
}
