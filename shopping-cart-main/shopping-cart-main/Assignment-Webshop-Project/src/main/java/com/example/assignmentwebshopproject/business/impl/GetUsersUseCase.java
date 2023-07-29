package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.GetAllUsersRequestDTO;
import com.example.assignmentwebshopproject.dto.GetUsersResponseDTO;



public interface GetUsersUseCase {
    GetUsersResponseDTO getUsers(GetAllUsersRequestDTO requestDTO);
}
